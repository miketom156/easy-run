package com.job5156.common.util;

import com.job5156.common.Constants;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    /**
     * 正则表达式过滤邮件地址
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        if(StringUtils.isNotBlank(email)){
            Pattern pattern = Pattern.compile(Constants.PATTERN_EMAIL, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            return matcher.find();
        }
        return false;
    }

    /**
     * 多个EMAIL列表，只取有效的一个
     * @param emailStr
     * @return
     */
    public static String getOneVaildEmail(String emailStr) {
        String email = "";
        if (StringUtils.isNotBlank(emailStr)) {
            String [] emArr = StringUtils.split(emailStr,";");
            for (String em: emArr){
                if(checkEmail(em)){
                    email = em;
                    break;
                }
            }
        }
        return email;
    }
}

