package com.job5156.vo.com;


/**
 * 企业得分（用于系统推荐简历，大于30分就推送）
 *
 * @author pzm
 *         2015-07-01
 */
public class ComGradeVo {

    /**
     * 企业id
     */
    private Integer comId;
    /**
     * 一周内收到简历数
     */
    private Integer resumeCountWeekly = 0;
    /**
     * 一周内收到简历得分
     */
    private Integer comReceiveScore = 0;
    /**
     * 一月内智通推荐简历数（未读）
     */
    private Integer sysRecommendUnreadCountMonthly = 0;
    /**
     * 一月内智通推荐简历数（已读）
     */
    private Integer sysRecommendReadedCountMonthly = 0;
    /**
     * 一个月内推荐简历查看率得分
     */
    private Integer readRecommendScore = 0;

    public ComGradeVo(Integer comId) {
        this.comId = comId;
    }

    public int computeComReceiveScore() {
        if (resumeCountWeekly <= 2) {
            comReceiveScore = 20;
        } else if (resumeCountWeekly <= 5) {
            comReceiveScore = 15;
        } else if (resumeCountWeekly <= 10) {
            comReceiveScore = 10;
        } else {
            comReceiveScore = 5;
        }
        return comReceiveScore;
    }

    public int computeReadRecommendScore() {
        //一个月没推荐，应该满分多推荐
        if (sysRecommendReadedCountMonthly == 0 && sysRecommendUnreadCountMonthly == 0) {
            readRecommendScore = 20;
            return readRecommendScore;
        }
        float readPercent = (float) sysRecommendReadedCountMonthly / (sysRecommendUnreadCountMonthly + sysRecommendReadedCountMonthly);
        if (readPercent < 0.3) {
            readRecommendScore = 5;
        } else if (resumeCountWeekly < 0.6) {
            readRecommendScore = 10;
        } else if (resumeCountWeekly < 0.9) {
            readRecommendScore = 15;
        } else {
            readRecommendScore = 20;
        }
        return readRecommendScore;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getComReceiveScore() {
        return comReceiveScore;
    }

    public Integer getResumeCountWeekly() {
        return resumeCountWeekly;
    }

    public void setResumeCountWeekly(Integer resumeCountWeekly) {
        this.resumeCountWeekly = resumeCountWeekly;
    }

    public Integer getSysRecommendUnreadCountMonthly() {
        return sysRecommendUnreadCountMonthly;
    }

    public void setSysRecommendUnreadCountMonthly(Integer sysRecommendUnreadCountMonthly) {
        this.sysRecommendUnreadCountMonthly = sysRecommendUnreadCountMonthly;
    }

    public Integer getSysRecommendReadedCountMonthly() {
        return sysRecommendReadedCountMonthly;
    }

    public void setSysRecommendReadedCountMonthly(Integer sysRecommendReadedCountMonthly) {
        this.sysRecommendReadedCountMonthly = sysRecommendReadedCountMonthly;
    }

    public Integer getReadRecommendScore() {
        return readRecommendScore;
    }

    public Integer getTotalScore() {
        computeComReceiveScore();
        computeReadRecommendScore();
        return readRecommendScore + comReceiveScore;
    }
}
