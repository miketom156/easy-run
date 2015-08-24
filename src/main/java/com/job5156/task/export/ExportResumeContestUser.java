package com.job5156.task.export;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Query;

import com.job5156.common.Constants;
import com.job5156.common.jedis.JedisFactory;
import com.job5156.common.jedis.JedisTemplate;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.model.per.PerResume;
import com.job5156.vo.per.PerEducationInfoVo;
import com.job5156.vo.per.PerResumeVo;

/**
 * <p>导出简历大赛用户</p>
 * Date: 2015/4/27 10:35
 *
 * @version 1.0
 * @autor: Lu Weibiao
 */
public class ExportResumeContestUser {
    JedisFactory jedisFactory = JedisFactory.getInstance();

    /**
     * 导出荆州简历大赛注册用户到指定excel文件
     * @param file
     * @throws IOException
     */
    public void exportJingZhouToExcel(File file) throws IOException{
        JedisTemplate jedisTemplate = jedisFactory.getJedisTemplate(Constants.ACT_RESUMECONTEST_REDISKEY);
        List<String> userStrIdList = jedisTemplate.readFromList(Constants.ACT_RESUMECONTEST_REDISKEY);
        List<Integer> userIds = convertStrIdList(userStrIdList);
        List<Map<String,Object>> userInfoList = getUserInfoList(userIds);
        //写入到 excel
        exportUserInfoListToExcel(file,userInfoList);

    }

    /**
     * 写入用户信息列表到指定excel文件
     * @param file
     * @param userInfoList
     * @throws IOException
     */
    private void exportUserInfoListToExcel(File file,List<Map<String,Object>> userInfoList) throws IOException{
        if(userInfoList == null){
            throw new RuntimeException("没有数据");
        }
        if(file == null){
            throw new RuntimeException("没有指定导出文件");
        }
        HSSFWorkbook workBook = new HSSFWorkbook();
        HSSFSheet sheet = workBook.createSheet();

        int i = 0;
        //表头
        HSSFRow headerRow = sheet.createRow(i++);
        headerRow.createCell(0).setCellValue("用户名");
        headerRow.createCell(1).setCellValue("手机号");
        headerRow.createCell(2).setCellValue("学校");
        headerRow.createCell(3).setCellValue("专业");

        for(Map<String,Object> userInfo : userInfoList){
            HSSFRow row = sheet.createRow(i);
            row.createCell(0).setCellValue(userInfo.get("userName") == null ? "" : userInfo.get("userName").toString());
            row.createCell(1).setCellValue(userInfo.get("mobile") == null ? "" : userInfo.get("mobile").toString());
            row.createCell(2).setCellValue(userInfo.get("schoolName") == null ? "" : userInfo.get("schoolName").toString());
            row.createCell(3).setCellValue(userInfo.get("speciality") == null ? "" : userInfo.get("speciality").toString());
            ++i;
        }

        if(!file.exists()){
            File dir = file.getParentFile();
            if(!dir.exists()){
                dir.mkdirs();
            }
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file);
        try {
            workBook.write(out);
        }finally {
            out.close();
        }
    }

    /**
     * 转换字符串型id为整型
     * @param userStrIdList
     * @return
     */
    private List<Integer> convertStrIdList(List<String> userStrIdList) {
        if(userStrIdList == null || userStrIdList.isEmpty()) {
            return null;
        }
        List<Integer> userIds = new ArrayList<>(userStrIdList.size());
        for(String strId : userStrIdList){
            userIds.add(Integer.valueOf(strId));
        }
        return userIds;
    }

    /**
     * 根据id列表获取用户信息列表
     * @param userIds
     * @return
     */
    private List<Map<String,Object>> getUserInfoList(List<Integer> userIds){
        List<Map<String,Object>> userInfoList = new ArrayList<>(userIds.size());
        //获取所有用户信息
        String hql = "select new map(u.userName as userName,u.mobile as mobile,u.phone as phone,u.defaultPerResume as defaultPerResume) from PerUser u where u.id = ?";
        try {
            for (Integer id : userIds) {
                Query query = HibernateSalveBaseUtil.currentSession().createQuery(hql);
                query.setParameter(0, id);
                Map<String, Object> userInfoMap = (Map<String, Object>) query.uniqueResult();
                if (userInfoMap == null) {
                    continue;
                }
                String schoolName = null;
                String speciality = null;

                //简历信息- 获取学校和专业
                PerResumeVo perResumeVo;
                try {
                    perResumeVo = new PerResumeVo((PerResume) userInfoMap.get("defaultPerResume"));
                    List<PerEducationInfoVo> educationInfoVoList = perResumeVo.getEducationInfoVoList();
                    if (educationInfoVoList != null && !educationInfoVoList.isEmpty()) {
                    	PerEducationInfoVo educationInfoVo = educationInfoVoList.get(0);
                        schoolName = educationInfoVo.getSchoolName();
                        speciality = educationInfoVo.getSpeciality();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                userInfoMap.put("schoolName", schoolName);
                userInfoMap.put("speciality", speciality);
                userInfoMap.remove("defaultPerResume");
                userInfoList.add(userInfoMap);
            }
        }finally {
            HibernateSalveBaseUtil.closeSession();
        }
        return userInfoList;
    }
}
