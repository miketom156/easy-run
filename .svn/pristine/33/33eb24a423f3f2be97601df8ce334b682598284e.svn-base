package com.job5156.beans;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.model.com.ComPosition;
import com.job5156.model.per.PerResume;

public class ResumeMatchingAnalyzerTest extends TestCase {

    public void testGetResumeMatchScore() throws Exception {
        ResumeMatchingAnalyzer resumeMatchingAnalyzer = new ResumeMatchingAnalyzer();
        String posSql = "8093545";
        Integer resumeId = 3930747;
        JdbcTemplate jdbcTemplateSlave = HibernateSalveBaseUtil.getJdbcTemplate();
        PerResume perResume = (PerResume)HibernateSalveBaseUtil.currentSession().get(PerResume.class, resumeId);

        String sql = "SELECT cp.id, cp.pos_name, cp.com_id, cp.email, cp.filter_res, cp.req_gender, cp.req_degree, cp.req_age_min, cp.req_age_max,"
                + "cp.req_work_year, cp.req_location, cp.req_language, cp.pos_keyword, cp.work_location, cp.pos_type, cp.tao_label"
                + " FROM com_position cp WHERE cp.id in (" + posSql + ")";
        List<ComPosition> posList = jdbcTemplateSlave.query(sql, new BeanPropertyRowMapper(ComPosition.class));
        resumeMatchingAnalyzer.getResumeMatchScore(posList.get(0),perResume);
        HibernateSalveBaseUtil.closeSession();
    }
}