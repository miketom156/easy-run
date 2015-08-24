package com.job5156.common;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: DJH
 * Date: 14-10-17
 * Time: 上午9:49
 * 接口调用类型枚举类型
 */
public enum ApiCallTypeEnum {
    /**
     * 手机
     */
    MOBILE("mobile","手机应用"),
    /**
     * 微信
     */
    WECHAT("wechat","微信"),
    /**
     * 网站
     */
    WEB("web","网站"),
    /**
     * 触屏版
     */
    TOUCH("touch","触屏版");

    private String enName;
    private String cnName;//对应中文名称
    private static Map<String,String> enCnMap ; //中英文名称对应关系
    static{
        enCnMap = Maps.newHashMap();
        for(ApiCallTypeEnum enCn:ApiCallTypeEnum.values()){
            enCnMap.put(enCn.enName,enCn.cnName);
        }
        enCnMap = ImmutableMap.copyOf(enCnMap);
    }

    ApiCallTypeEnum(String enName,String cnName){
        this.enName=enName;
        this.cnName=cnName;
    }

    public static Map<String, String> getEnCnMap() {
        return enCnMap;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }
}
