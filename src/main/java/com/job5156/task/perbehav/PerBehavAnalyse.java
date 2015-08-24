package com.job5156.task.perbehav;

import com.google.gson.Gson;
import com.job5156.common.CommonEnum;
import com.job5156.common.IpSeekerComponent;
import com.job5156.common.PerResumeCheckComponent;
import com.job5156.common.option.OptionMap;
import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateUtil;
import com.job5156.model.per.PerResume;
import com.job5156.model.per.PerUser;
import com.job5156.model.perbehav.PerBehavTrack;
import com.job5156.model.perbehav.UvTrack;
import com.job5156.model.sys.SysFromSource;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.*;

/**
 * 职位发布分析
 * Created by pzm on 2015/1/20.
 */
public class PerBehavAnalyse {
    JdbcTemplate countJdbcTemplate = HibernateCountUtil.getJdbcTemplate();
    JdbcTemplate baseJdbcTemplate = HibernateUtil.getJdbcTemplate();
    JdbcTemplate actionJdbcTemplate = HibernateActionUtil.getJdbcTemplate();
    Session countSession = HibernateCountUtil.currentSession();
    Session session = HibernateUtil.currentSession();
    private Logger logger = Logger.getLogger(PerBehavAnalyse.class);

    private IpSeekerComponent ipSeekerComponent = new IpSeekerComponent();
    private PerResumeCheckComponent perResumeCheckComponent = new PerResumeCheckComponent();
    private int insertUvSucCount = 0, updateUvSucCount = 0, insertPerSucCount = 0, regPerSucCount = 0, updatePerSucCount = 0, failCount = 0;

    /**
     * 更新用户行为跟踪表的活跃度（投递量，刷新量，登录量）
     *
     * @param fromDate
     * @param toDate
     */
    public void updatePerActivity(Date fromDate, Date toDate) {
        logger.info(String.format("[%s] start! fromDate:%s, toDate:%s", Thread.currentThread().getStackTrace()[1].getMethodName(), fromDate == null ? "" : new DateTime(fromDate).toString("yyyy-MM-dd"), toDate == null ? "" : new DateTime(toDate).toString("yyyy-MM-dd")));
        List args = new ArrayList();
        String sqlWhere = "";
        if (fromDate != null) {
            sqlWhere += " and reg_time>=?";
            args.add(new DateTime(fromDate).toString("yyyy-MM-dd"));
        }
        if (toDate != null) {
            sqlWhere += " and reg_time<?";
            args.add(new DateTime(toDate).plusDays(1).toString("yyyy-MM-dd"));
        }
        long all = countJdbcTemplate.queryForObject("select count(*) from per_behav_track where 1=1" + sqlWhere, Long.class, args.toArray());
        int step = 0, size = 2000;
        for (; step < all; step += size) {
            List<Map<String, Object>> personList = countJdbcTemplate.queryForList("select per_user_id from per_behav_track where 1=1" + sqlWhere, args.toArray());
            for (Map<String, Object> per : personList) {
                try {
                    List argsPer = new ArrayList();
                    Integer userId = (Integer) per.get("per_user_id");
                    argsPer.add(baseJdbcTemplate.queryForInt("select count(*) from per_login_history where per_user_id=?", userId));
                    argsPer.add(actionJdbcTemplate.queryForInt("select count(*) from per_resume_refresh where user_id=?", userId));
                    argsPer.add(actionJdbcTemplate.queryForInt("select count(*) from per_pos_apply where per_user_id=?", userId));
                    argsPer.add(userId);
                    countJdbcTemplate.update("update per_behav_track set apply_count=?,refresh_count=?,login_count=? where per_user_id=?", argsPer.toArray());
                    updatePerSucCount++;
                } catch (Exception e) {
                    logger.error("updatePerActivity fail!", e);
                    failCount++;
                }
            }
            logger.info("updatePerActivity finish:" + (step + size));
        }
        logger.info(String.format("[%s] end! 更新用户成功:%s, 失败:%s", Thread.currentThread().getStackTrace()[1].getMethodName(), updatePerSucCount, failCount));
    }

    public void importPerBehavTrack(Date fromDate, Date toDate) {
        logger.info(String.format("[%s] start! fromDate:%s, toDate:%s", Thread.currentThread().getStackTrace()[1].getMethodName(), fromDate == null ? "" : new DateTime(fromDate).toString("yyyy-MM-dd"), toDate == null ? "" : new DateTime(toDate).toString("yyyy-MM-dd")));
        List args = new ArrayList();
        String sqlWhere = "";
        if (fromDate != null) {
            sqlWhere += " and credate>=?";
            args.add(new DateTime(fromDate).toString("yyyy-MM-dd"));
        }
        if (toDate != null) {
            sqlWhere += " and credate<?";
            args.add(new DateTime(toDate).plusDays(1).toString("yyyy-MM-dd"));
        }
        long all = countJdbcTemplate.queryForObject("select count(*) from PV_Person_Register where 1=1" + sqlWhere, Long.class, args.toArray());
        int step = 0, size = 10000;
        for (; step < all; step += size) {
            List argsB = new ArrayList(args);
            List<Map<String, Object>> personList;
            argsB.add(step);
            argsB.add(size);
            personList = countJdbcTemplate.queryForList("select * from PV_Person_Register where 1=1" + sqlWhere + " order by credate,id limit ?,?", argsB.toArray());
            for (Map<String, Object> pvPersonRegister : personList) {
                try {
                    importPerBehavTrack(pvPersonRegister);
                    insertPerSucCount++;
                } catch (Exception e) {
                    logger.error(e.toString(), e);
                    failCount++;
                }
            }
        }
        logger.info(String.format("[%s] end! 导入用户:%s, 失败:%s", Thread.currentThread().getStackTrace()[1].getMethodName(), insertPerSucCount, failCount));
    }

    public void gentPerBehavTrack(Date fromDate, Date toDate) {
        logger.info(String.format("[%s] start! fromDate:%s, toDate:%s", Thread.currentThread().getStackTrace()[1].getMethodName(), new DateTime(fromDate).toString("yyyy-MM-dd"), new DateTime(toDate).toString("yyyy-MM-dd")));
        Date dateStep = fromDate;
        while (!dateStep.after(toDate)) {
            String perBehavLogTableName = "per_behavior_log_" + new DateTime(dateStep).withDayOfWeek(1).toString("yyyyMMdd") + "_" + new DateTime(dateStep).withDayOfWeek(7).toString("yyyyMMdd");
            try {
                countJdbcTemplate.queryForList("select count(1) from " + perBehavLogTableName + " limit 1");
            } catch (Exception e) {
                perBehavLogTableName = "per_behavior_log";
            }
            List<Map<String, Object>> logList;
            long all = countJdbcTemplate.queryForObject("select count(1) from " + perBehavLogTableName + " where logtime>=? and logtime<?", Long.class, new DateTime(dateStep).withTimeAtStartOfDay().toDate(), new DateTime(dateStep).plusDays(1).withTimeAtStartOfDay().toDate());
            int step = 0, size = 10000;
            for (; step < all; step += size) {
                logList = countJdbcTemplate.queryForList("select * from " + perBehavLogTableName + " where logtime>=? and logtime<? order by logtime,id limit ?,?", new DateTime(dateStep).withTimeAtStartOfDay().toDate(), new DateTime(dateStep).plusDays(1).withTimeAtStartOfDay().toDate(), step, size);
                for (Map<String, Object> perBehavLog : logList) {
                    try {
                        String cmd = ObjectUtils.toString(perBehavLog.get("cmd"), "");
                        Integer pid = (Integer) perBehavLog.get("pid");
                        Date logTime = (Date) ObjectUtils.defaultIfNull(perBehavLog.get("logtime"), new Date(0));
                        Map jsonInfo = StringUtils.isBlank(ObjectUtils.toString(perBehavLog.get("jsoninfo"), "")) ? new HashMap() : new Gson().fromJson(ObjectUtils.toString(perBehavLog.get("jsoninfo"), ""), Map.class);

                        //更新访客记录
                        UvTrack uvTrack = processUv(perBehavLog);

                        //注册
                        if (isRegCmd(cmd)) {
                            String perUserAccount = ObjectUtils.toString(jsonInfo.get("account"), "");
                            if (StringUtils.isNotBlank(perUserAccount)) {
                                PerUser perUser = getPerUser(perUserAccount);
                                if (perUser != null) {
                                    if (getPerBehavTrack(perUser.getId()) != null) {
                                        continue;
                                    } else {
                                        createPerBehavTrackByRegLog(perUser, perBehavLog);
                                        regPerSucCount++;
                                        if (uvTrack != null) {
                                            uvTrack.setRegPid(perUser.getId());
                                            countSession.update(uvTrack);
                                            updateUvSucCount++;
                                        }
                                        continue;
                                    }
                                }
                            }
                        }

                        //登录
                        if (isLogin(cmd)) {
                            String perUserAccount = ObjectUtils.toString(jsonInfo.get("userName"), "");
                            if (StringUtils.isNotBlank(perUserAccount)) {
                                Integer perUserId = getPerUserId(perUserAccount);
                                if (perUserId != null) {
                                    PerBehavTrack perBehavTrack = getOrCreatePerBehavTrack(perUserId);
                                    if (perBehavTrack != null) {
                                        perBehavTrack.setLoginCount(perBehavTrack.getLoginCount() + 1);
                                        perBehavTrack.setLastLoginTime(logTime);
                                        countSession.update(perBehavTrack);
                                        updatePerSucCount++;
                                        if (uvTrack != null) {
                                            uvTrack.setLastLoginPid(perUserId);
                                            countSession.update(uvTrack);
                                            updateUvSucCount++;
                                        }
                                        continue;
                                    }
                                }
                            }
                        }

                        //处理用户
                        if (pid != null) {
                            PerBehavTrack perBehavTrack = getOrCreatePerBehavTrack(pid);
                            if (perBehavTrack != null) {
                                //注册微名片
                                if (isRegMicroCard(cmd)) {
                                    perBehavTrack.setIsRegMicroCard(1);
                                    perBehavTrack.setRegResumeTime(logTime);
                                    countSession.update(perBehavTrack);
                                    updatePerSucCount++;
                                    continue;
                                }
                                //注册普通简历
                                if (isRegResume(cmd)) {
                                    boolean isMicreCard = false;
                                    PerResume perResume = getPerResumeByPid(perBehavTrack.getPerUserId());
                                    if (perResume != null) {
                                        if (perResume.getResumeType() != null && perResume.getResumeType() == 4) {
                                            isMicreCard = true;
                                        }
                                    }
                                    if (isMicreCard) {
                                        perBehavTrack.setIsRegMicroCard(1);
                                    } else {
                                        perBehavTrack.setIsRegResume(1);
                                    }
                                    perBehavTrack.setRegResumeTime(logTime);
                                    countSession.update(perBehavTrack);
                                    updatePerSucCount++;
                                    continue;
                                }
                                //刷新
                                if (isRefresh(cmd)) {
                                    perBehavTrack.setRefreshCount(perBehavTrack.getRefreshCount() + 1);
                                    perBehavTrack.setLastRefreshTime(logTime);
                                    countSession.update(perBehavTrack);
                                    updatePerSucCount++;
                                    continue;
                                }
                                //应聘
                                if (isApply(cmd)) {
                                    perBehavTrack.setApplyCount(perBehavTrack.getApplyCount() + 1);
                                    perBehavTrack.setLastApplyTime(logTime);
                                    countSession.update(perBehavTrack);
                                    updatePerSucCount++;
                                    continue;
                                }
                                //搜索
                                if (isSearchPos(cmd)) {
                                    perBehavTrack.setSearchPosCount(perBehavTrack.getSearchPosCount() + 1);
                                    perBehavTrack.setLastSearchTime(logTime);
                                    countSession.update(perBehavTrack);
                                    updatePerSucCount++;
                                    continue;
                                }
                            } else {
                                logger.warn(String.format("[%s] PerBehavTrack not exist! pid:%s", Thread.currentThread().getStackTrace()[1].getMethodName(), pid));
                            }
                        }
                        //企业邀请面试
                        if (isComInterview(cmd)) {
                            processComInterview(perBehavLog);
                        }
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                        failCount++;
                    }
                }
                logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " process " + (step + size) + " log");
                countSession.clear();
                session.clear();
            }
            dateStep = new DateTime(dateStep).minusDays(-1).withTimeAtStartOfDay().toDate();
        }
        logger.info(String.format("[%s] end! 注册用户%s,导入用户:%s, 更新用户:%s, 新增访客:%s, 更新访客:%s, 失败:%s", Thread.currentThread().getStackTrace()[1].getMethodName(), regPerSucCount, insertPerSucCount, updatePerSucCount, insertUvSucCount, updateUvSucCount, failCount));
    }

    private void processComInterview(Map perBehavLog) {
        Map jsonInfo = StringUtils.isBlank(ObjectUtils.toString(perBehavLog.get("jsoninfo"), "")) ? new HashMap() : new Gson().fromJson(ObjectUtils.toString(perBehavLog.get("jsoninfo"), ""), Map.class);
        String resumeListStr = ObjectUtils.toString(jsonInfo.get("resumeList"), "");
        if (StringUtils.isNotBlank(resumeListStr)) {
            List resumeList = new Gson().fromJson(resumeListStr, List.class);
            for (Object resumeInfoObj : resumeList) {
                Map resumeInfo = (Map) resumeInfoObj;
                String perUserId = ObjectUtils.toString(resumeInfo.get("perUserId"), "");
                if (StringUtils.isNotBlank(perUserId)) {
                    PerBehavTrack perBehavTrack = getPerBehavTrack(Integer.parseInt(perUserId));
                    if (perBehavTrack != null) {
                        perBehavTrack.setComInterviewCount(perBehavTrack.getComInterviewCount() + 1);
                        updatePerSucCount++;
                    }
                }
            }
        } else {
            String perUserId = ObjectUtils.toString(jsonInfo.get("perUserId"), "");
            if (StringUtils.isNotBlank(perUserId)) {
                PerBehavTrack perBehavTrack = getOrCreatePerBehavTrack(Integer.parseInt(perUserId));
                if (perBehavTrack != null) {
                    perBehavTrack.setComInterviewCount(perBehavTrack.getComInterviewCount() + 1);
                    updatePerSucCount++;
                }
            }
        }
    }

    private UvTrack processUv(Map<String, Object> perBehavLog) {
        UvTrack uvTrack = null;
        try {
            Integer originflag = (Integer) perBehavLog.get("originflag");
            String uvCookie = ObjectUtils.toString(perBehavLog.get("uvcookie"), "");
            Date logTime = (Date) ObjectUtils.defaultIfNull(perBehavLog.get("logtime"), new Date(0));

            //处理访客
            if (StringUtils.isNotBlank(uvCookie)) {
                uvTrack = getUvTrack(uvCookie);
                if (uvTrack == null) {
                    uvTrack = createUvTrack(perBehavLog);
                    insertUvSucCount++;
                } else {
                    if (originflag == 1) {
                        //二次访问
                        //记录老用户
                        uvTrack.setAccessCount(uvTrack.getAccessCount() + 1);
                        uvTrack.setLastAccessTime(logTime);
                        countSession.update(uvTrack);
                        updateUvSucCount++;
                    }
                }
            }
        } catch (Exception e) {
            logger.error(String.format("[%s] processUv Fail!", Thread.currentThread().getStackTrace()[2].getMethodName()), e);
            failCount++;
        }
        return uvTrack;
    }

    private PerBehavTrack getPerBehavTrack(Integer pid) {
        return (PerBehavTrack) countSession.get(PerBehavTrack.class, pid);
    }

    private PerBehavTrack getOrCreatePerBehavTrack(Integer pid) {
        PerBehavTrack perBehavTrack = getPerBehavTrack(pid);
        if (perBehavTrack == null) {
            PerUser perUser = (PerUser) session.get(PerUser.class, pid);
            if (perUser != null) {
                //create PerBehavTrack
                perBehavTrack = importPerBehavTrack(perUser);
                insertPerSucCount++;
            }
        }
        return perBehavTrack;
    }

    private UvTrack getUvTrack(String uvid) {
        return (UvTrack) countSession.get(UvTrack.class, uvid);
    }

    private boolean isRegCmd(String cmd) {
        return cmd.equals("reg");
    }

    private boolean isRegMicroCard(String cmd) {
        return cmd.equals("regMicroCard");
    }

    private boolean isRegResume(String cmd) {
        return cmd.equals("regResume");
    }

    private boolean isRefresh(String cmd) {
        return cmd.equals("refresh");
    }

    private boolean isLogin(String cmd) {
        return cmd.equals("login");
    }

    private boolean isApply(String cmd) {
        return cmd.equals("applyPos");
    }

    private boolean isSearchPos(String cmd) {
        return cmd.equals("searchPos");
    }

    private boolean isComInterview(String cmd) {
        return cmd.equals("com:interviewFair") || cmd.equals("com:interviewOffice");
    }

    private PerResume getPerResumeByPid(Integer pid) {
        PerUser perUser = getPerUser(pid);
        if (perUser != null) {
            return perUser.getDefaultPerResume();
        } else {
            return null;
        }

    }

    private com.job5156.model.per.PerUser getPerUser(String account) {
        List<PerUser> list = session.createQuery("from PerUser where account=?").setParameter(0, account).list();
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    private com.job5156.model.per.PerUser getPerUser(Integer pid) {
        return (PerUser) session.get(PerUser.class, pid);
    }

    private Integer getPerUserId(String account) {
        List<Map<String, Object>> list = HibernateUtil.getJdbcTemplate().queryForList("select id from per_user where account=?", account);
        if (!list.isEmpty()) {
            return (Integer) list.get(0).get("id");
        }
        return 0;
    }

    private UvTrack createUvTrack(Map perBehavLog) {
        if (StringUtils.isBlank(ObjectUtils.toString(perBehavLog.get("uvcookie"), ""))) {
            return null;
        }
        String fDomain = ObjectUtils.toString(perBehavLog.get("fdomain"), "");
        String fAddr = ObjectUtils.toString(perBehavLog.get("faddr"), "");
//        String tAddr = ObjectUtils.toString(perBehavLog.get("taddr"), "");
        String spreadItemTn = ObjectUtils.toString(perBehavLog.get("spread_tn"), "");
        String spreadItemName = getSpreadItemNameByTn(spreadItemTn);
        String semSpreadTn = ObjectUtils.toString(perBehavLog.get("sem_spread_tn"), "");
        String semSpreadTnName = getSpreadItemNameByTn(semSpreadTn);
        SysFromSource sysFromSource = new SysFromSource();
        Integer fromSourceType = null;
        try {
            sysFromSource.parseFromSourceUrl(fDomain, fAddr);
            fromSourceType = sysFromSource.getSourceType();
        } catch (Exception e) {
            logger.warn("createUvTrack parse from source fail! url:" + fDomain + fAddr);
        }
        String ip = (String) perBehavLog.get("ip");
        String ipProv = null, ipCity = null;
        if (StringUtils.isNotBlank(ip)) {
            try {
                String ipAddress = ipSeekerComponent.getAddress((String) perBehavLog.get("ip"));
                Integer cityCode = OptionMap.getCityCodeByAddr(ipAddress, CommonEnum.AreaType.CITY);
                ipProv = OptionMap.getProvAddr(cityCode);
                ipCity = OptionMap.getCityAddr(cityCode);
            } catch (Exception e) {
                //ignore
            }
        }
        int rs = countJdbcTemplate.update("insert into uv_track (" +
                        "uv_id," +
                        "first_access_time," +
                        "last_access_time," +
                        "access_type," +
                        "access_count," +
                        "spread_tn," +
                        "spread_name," +
                        "sem_spread_tn," +
                        "sem_spread_name," +
                        "from_source_type," +
                        "from_source_domain," +
                        "from_source_addr," +
                        "create_time," +
                        "ip," +
                        "ip_prov," +
                        "ip_city) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                perBehavLog.get("uvcookie"),
                perBehavLog.get("logtime"),
                perBehavLog.get("logtime"),
                perBehavLog.get("accesstype"),
                1,
                spreadItemTn,
                spreadItemName,
                semSpreadTn,
                semSpreadTnName,
                fromSourceType,
                fDomain,
                fAddr,
                new Date(),
                ip,
                ipProv,
                ipCity
        );
        return (UvTrack) countSession.get(UvTrack.class, ObjectUtils.toString(perBehavLog.get("uvcookie"), ""));
    }

    private void createPerBehavTrackByRegLog(PerUser perUser, Map perBehavLog) {
        String spreadItemTn = ObjectUtils.toString(perBehavLog.get("spread_tn"), "");
        String spreadItemName = getSpreadItemNameByTn(spreadItemTn);
        String semSpreadTn = ObjectUtils.toString(perBehavLog.get("sem_spread_tn"), "");
        String semSpreadTnName = getSpreadItemNameByTn(semSpreadTn);
        Date logTime = (Date) ObjectUtils.defaultIfNull(perBehavLog.get("logtime"), new Date(0));

        PerBehavTrack perBehavTrack = new PerBehavTrack();
        perBehavTrack.setUvId((String) perBehavLog.get("uvcookie"));
        perBehavTrack.setAccessType((String) perBehavLog.get("accesstype"));
        perBehavTrack.setSpreadTn(spreadItemTn);
        perBehavTrack.setSpreadName(spreadItemName);
        perBehavTrack.setSemSpreadTn(semSpreadTn);
        perBehavTrack.setSemSpreadName(semSpreadTnName);
        perBehavTrack.setFromSourceType((Integer) perBehavLog.get("from_source_type"));
        perBehavTrack.setFromSourceDomain((String) perBehavLog.get("from_source_domain"));
        perBehavTrack.setFromSourceAddr((String) perBehavLog.get("from_source_addr"));
        perBehavTrack.setRegTime(logTime);
        //用户属性
        perBehavTrack.setUserIp((String) perBehavLog.get("ip"));
        if (StringUtils.isNotBlank((String) perBehavLog.get("ip"))) {
            try {
                String ipAddress = ipSeekerComponent.getAddress((String) perBehavLog.get("ip"));
                Integer cityCode = OptionMap.getCityCodeByAddr(ipAddress, CommonEnum.AreaType.CITY);
                perBehavTrack.setUserIpProv(OptionMap.getProvAddr(cityCode));
                perBehavTrack.setUserIpCity(OptionMap.getCityAddr(cityCode));
            } catch (Exception e) {
                //ignore
            }
        }
        setPerUserProperty(perBehavTrack, perUser);
        countSession.save(perBehavTrack);
        countSession.flush();
    }

    private PerBehavTrack importPerBehavTrack(Map pvPersonRegister) {
        Integer pid = (Integer) pvPersonRegister.get("userId");
        if (getPerBehavTrack(pid) != null) {
            logger.warn("duplicate import PerBehavTrack!pid:" + pid);
            return getPerBehavTrack(pid);
        }
        String fromUrl = ObjectUtils.toString(pvPersonRegister.get("fromUrl"), "");
        SysFromSource sysFromSource = new SysFromSource();
        String fDomain = "";
        String fAddr = "";
        Integer sourceType = SysFromSource.SOURCE_TYPE_SELFACCESS;
        try {
            sysFromSource.parseFromSourceUrl(fromUrl);
            fDomain = sysFromSource.getSourceDomain();
            fAddr = sysFromSource.getSourceAddr();
            sourceType = sysFromSource.getSourceType();
        } catch (Exception e) {
            logger.warn("importPerBehavTrack parse from source fail! url:" + fromUrl);
        }
        String spreadItemTn = ObjectUtils.toString(pvPersonRegister.get("register"), "");
        String spreadItemName = getSpreadItemNameByTn(spreadItemTn);
        String semSpreadTn = ObjectUtils.toString(pvPersonRegister.get("semRegister"), "");
        String semSpreadTnName = getSpreadItemNameByTn(semSpreadTn);

        PerBehavTrack perBehavTrack = new PerBehavTrack();
        perBehavTrack.setSpreadTn(spreadItemTn);
        perBehavTrack.setSpreadName(spreadItemName);
        perBehavTrack.setSemSpreadTn(semSpreadTn);
        perBehavTrack.setSemSpreadName(semSpreadTnName);
        perBehavTrack.setFromSourceType(sourceType);
        perBehavTrack.setFromSourceDomain(fDomain);
        perBehavTrack.setFromSourceAddr(fAddr);
        perBehavTrack.setRegTime((Date) pvPersonRegister.get("credate"));
        perBehavTrack.setUserIp((String) pvPersonRegister.get("userIp"));
        if (StringUtils.isNotBlank((String) pvPersonRegister.get("userIp"))) {
            try {
                String ipAddress = ipSeekerComponent.getAddress((String) pvPersonRegister.get("userIp"));
                Integer cityCode = OptionMap.getCityCodeByAddr(ipAddress, CommonEnum.AreaType.CITY);
                perBehavTrack.setUserIpProv(OptionMap.getProvAddr(cityCode));
                perBehavTrack.setUserIpCity(OptionMap.getCityAddr(cityCode));
            } catch (Exception e) {
                //ignore
            }
        }
        PerUser perUser = (PerUser) session.get(PerUser.class, pid);
        if (perUser != null) {
            setPerUserProperty(perBehavTrack, perUser);
        }
        countSession.save(perBehavTrack);
        countSession.flush();
        return perBehavTrack;
    }

    private PerBehavTrack importPerBehavTrack(PerUser perUser) {
        List<Map<String, Object>> list = countJdbcTemplate.queryForList("select * from PV_Person_Register where userId=?", perUser.getId());
        if (list != null && !list.isEmpty()) {
            Map pvPersonRegister = list.get(0);
            return importPerBehavTrack(pvPersonRegister);
        } else {
            //微信或者app注册的用户
            PerBehavTrack perBehavTrack = new PerBehavTrack();
            perBehavTrack.setRegTime(perUser.getCreateDate());
            perBehavTrack.setUserIp(perUser.getIp());
            if (StringUtils.isNotBlank(perUser.getIp())) {
                String ipProv = null;
                String ipCity = null;
                try {
                    String ipAddress = ipSeekerComponent.getAddress(perUser.getIp());
                    Integer cityCode = OptionMap.getCityCodeByAddr(ipAddress, CommonEnum.AreaType.CITY);
                    ipProv = OptionMap.getProvAddr(cityCode);
                    ipCity = OptionMap.getCityAddr(cityCode);
                } catch (Exception e) {
                    //ignore
                }
                perBehavTrack.setUserIpProv(ipProv);
                perBehavTrack.setUserIpCity(ipCity);
            }
            setPerUserProperty(perBehavTrack, perUser);
            countSession.save(perBehavTrack);
            countSession.flush();
            return perBehavTrack;
        }
    }

    private void setPerUserProperty(PerBehavTrack perBehavTrack, PerUser perUser) {
        PerResume perResume = perUser.getDefaultPerResume();
        perBehavTrack.setPerUserId(perUser.getId());
        perBehavTrack.setAccountFrom(CommonEnum.ComeFrom.getTypeByValue(perUser.getAccountFrom()).getName());
        //用户属性
        perBehavTrack.setGender(OptionMap.getValue(OptionMap.OptionType.OPT_GENDER, perUser.getGender()));
        perBehavTrack.setAge(perUser.getAge());
        perBehavTrack.setWorkYear(OptionMap.getValue(OptionMap.OptionType.OPT_PER_WORKYEAR, perUser.getJobyearType()));
        perBehavTrack.setLocationProv(OptionMap.getProvAddr(perUser.getLocation()));
        perBehavTrack.setLocationCity(OptionMap.getCityAddr(perUser.getLocation()));
        perBehavTrack.setMobile(perUser.getMobile());
        perBehavTrack.setMobilePlace(getMobilePlace(perUser.getMobile()));
        if (StringUtils.isBlank(perBehavTrack.getAccessType()) && perUser.getAccountFrom() != null) {
            if (perUser.getAccountFrom() == CommonEnum.ComeFrom.TOUCH_REG.getValue()) {
                perBehavTrack.setAccessType("touch");
            } else if (perUser.getAccountFrom() == CommonEnum.ComeFrom.MOBILE_REG.getValue()) {
                perBehavTrack.setAccessType("app");
            } else if (perUser.getAccountFrom() == CommonEnum.ComeFrom.WECHAT_REG.getValue()) {
                perBehavTrack.setAccessType("wechat");
            } else {
                perBehavTrack.setAccessType("web");
            }
        }
        if (perResume != null) {
            try {
                Map<String, Object> map = perResume.getMap();
                perBehavTrack.setDegree((String) map.get("degreeStr"));
                perBehavTrack.setResumePass(CommonEnum.ResumeStatus.getResumeStatusForValue(perUser.getDefaultPerResume().getPass()).toString());
                perBehavTrack.setIsResumeComplete(perResumeCheckComponent.resumeComplete(perResume) ? 1 : 0);
                String expectJob = (String) map.get("expectJob");
                if (StringUtils.isNotBlank(expectJob)) {
                    String[] expectJobs = expectJob.split(",");
                    if (expectJobs.length > 0) {
                        perBehavTrack.setExpectJobCode1(expectJobs[0]);
                    }
                    if (expectJobs.length > 1) {
                        perBehavTrack.setExpectJobCode2(expectJobs[1]);
                    }
                    if (expectJobs.length > 2) {
                        perBehavTrack.setExpectJobCode3(expectJobs[2]);
                    }
                }
                perBehavTrack.setExpectSalary((String) map.get("expectSalaryStr"));

            } catch (Exception e) {
                e.printStackTrace();
            }
            if (perResume.getResumeType() != null && perResume.getResumeType() == 4) {
                perBehavTrack.setIsRegMicroCard(1);
            } else {
                perBehavTrack.setIsRegResume(1);
            }
        }
        perBehavTrack.setAccount(perUser.getAccount());

    }

    private String getMobilePlace(String mobile) {
        String phonePostUrl = "http://virtual.paipai.com/extinfo/GetMobileProductInfo?amount=10000&mobile=" + mobile;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String phoneloc = "";
        try {
            HttpGet httpost = new HttpGet(phonePostUrl);
            HttpResponse response = httpClient.execute(httpost);
            HttpEntity resEntity = response.getEntity();
            String jsonStr = EntityUtils.toString(resEntity, "utf-8");
            Map map2 = new Gson().fromJson(jsonStr.substring(jsonStr.indexOf("{"), jsonStr.lastIndexOf("}") + 1), Map.class);
            if (map2 != null) {
                phoneloc = map2.get("province").toString() + map2.get("cityname").toString();
            }
        } catch (Exception e) {
            try {
                httpClient.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return phoneloc;
    }

    private String findSpreadItemTn(String addr) {
        String spreadItemTn = null;
        try {
            if (addr.indexOf("?") != -1) {
                String paramStr = addr.substring(addr.indexOf("?") + 1);
                if (StringUtils.isNotBlank(paramStr)) {
                    for (String paramEntry : paramStr.split("&")) {
                        if (paramEntry.split("=")[0].equals("et")) {
                            spreadItemTn = paramEntry.split("=")[1];
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            //ignore;
        }
        return spreadItemTn;
    }

    private String getSpreadItemNameByTn(String tn) {
        if (StringUtils.isBlank(tn)) {
            return null;
        }
        try {
            List<Map<String, Object>> list = HibernateUtil.getJdbcTemplate().queryForList("select item_name from sys_count_item_setting where tn=? order by create_date desc", tn);
            if (list != null && list.size() > 0) {
                return (String) list.get(0).get("item_name");
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
