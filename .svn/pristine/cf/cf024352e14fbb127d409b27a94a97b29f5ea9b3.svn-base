package com.job5156.test;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.job5156.common.util.HibernateCountUtil;
import com.job5156.common.util.HibernateSalveBaseUtil;
import com.job5156.model.mail.EmailInvaild;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 导入硬弹邮箱列表
* @author : leeton
 */
public class ImportInvaildEmailList {

    private static String csvFile="e:/dmd_blacklist.csv";

    public static void main(String[] args) {
        ImportInvaildEmailList importInvaildEmailList = new ImportInvaildEmailList();
        importInvaildEmailList.importcsv(csvFile);
    }

    public List<EmailInvaild> importcsv(String csvFile) {
        List<EmailInvaild> emailInvailds = Lists.newArrayList();
        List<String> newListStr;
        try {
            File file = FileUtils.getFile(csvFile);
            newListStr = Files.readLines(file, Charsets.UTF_8);
            for (String s : newListStr) {
                EmailInvaild ev = new EmailInvaild();
                String[] strArr = StringUtils.split(s, ",");
                ev.setEmail(strArr[3]);
                ev.setCreateDate(DateTime.now().toDate());
                updateEmailBlackList(ev);
            }
            HibernateCountUtil.closeSession();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return emailInvailds;
    }

    private void updateEmailBlackList(EmailInvaild emailInvaild){
        if(StringUtils.isBlank(emailInvaild.getEmail())){
            return;
        }
        Session ses = HibernateSalveBaseUtil.currentSession();
        String isExistSql = " SELECT count(*) from email_invaild WHERE INSTR(email,'"+emailInvaild.getEmail()+"') >0";
        int isExist = NumberUtils.toInt(ses.createSQLQuery(isExistSql).uniqueResult() +"",0);

        if(isExist == 0){
            String sql = "INSERT email_invaild SET email=?, create_date='" + DateTime.now().toLocalDate()+"'";
           // ses.createSQLQuery(sql).executeUpdate();
           Query q= ses.createSQLQuery(sql) ;
            q.setParameter(0,emailInvaild.getEmail());
            q.executeUpdate();
            q=null;

        }

    }


}
