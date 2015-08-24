package com.job5156.common;

import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 15-3-24
 * Time: 下午3:09
 * To change this template use File | Settings | File Templates.
 */
public class ZhiPinDataTransferComponent {

    private static Logger logger = Logger.getLogger(ZhiPinDataTransferComponent.class);

    private Gson gson=new Gson();
    /**
     * 存放新旧数据key:旧数据  value:新数据
     */
    public static Map<String ,String> taoLabelMap=new HashMap<>();
    /**
     * 存放薪资数据
     */
    public static Map<Integer ,Integer[]>salaryMap=new HashMap<>();
    /**
     * redis中存放转换当前的企业ID
     */
    public  final    String REDIS_PRE_KEY_TRANSFER_DATA_COM="zp:transfer:data:com:id";//redis中存放转换当前的企业ID
    public  final    String REDIS_PRE_KEY_TRANSFER_DATA_MESSAGE="zp:transfer:data:com:message";//redis中存放转换当数据信息
    public  final    String REDIS_PRE_KEY_TRANSFER_DATA_STATUS="zp:transfer:data:com:status"; //run：正在运行   stop:已经停止  finish:任务已经完成
    public  final    Long   TRANSFER_EX_TIME=  24*3600*30l;

    static {
        //详细需求参见文档 http://192.168.8.27:3000/projects/pm/wiki/%E2%80%9C%E8%81%8C%E4%BD%8D%E4%BA%AE%E7%82%B9%E2%80%9D%E4%BC%98%E5%8C%96%E6%96%B9%E6%A1%88
        taoLabelMap.put("出差餐补","餐补");
        taoLabelMap.put("包食宿","包吃;包住");//两个标签
        taoLabelMap.put("住房补贴","房补");
        taoLabelMap.put("住房公积金","住房公积金"); //无变动
        taoLabelMap.put("五险一金","五险一金");//无变动
        taoLabelMap.put("有食堂","有食堂_new");//变更为自定义标签
        taoLabelMap.put("免费食堂","包吃");
        taoLabelMap.put("提供宿舍","包住");
        taoLabelMap.put("八小时工作制","8小时工作制");
        taoLabelMap.put("弹性工作时间","弹性工作时间");//无变动
        taoLabelMap.put("周末双休","双休");
        taoLabelMap.put("朝九晚五","朝9晚5");
        taoLabelMap.put("带薪年假","带薪年假");//无变动
        taoLabelMap.put("有加班费","加班补助");
        taoLabelMap.put("10天以上年假","10天以上年假_new"); //变更为自定义标签
        taoLabelMap.put("办公环境优美","办公环境优美");//无变动
        taoLabelMap.put("甲A写字楼","甲A写字楼_new");//变更为自定义标签
        taoLabelMap.put("独立工作间","独立工作间_new");//变更为自定义标签
        taoLabelMap.put("独立办公室","独立办公室_new");//变更为自定义标签
        taoLabelMap.put("笔记本电脑","笔记本电脑_new");//变更为自定义标签
        taoLabelMap.put("交通便利","交通便利");//无变动
        taoLabelMap.put("交通补贴","交通补助");
        taoLabelMap.put("地铁口","地铁口_new");//变更为自定义标签
        taoLabelMap.put("班车接送","免费班车");
        taoLabelMap.put("世界500强","世界500强_new");//变更为自定义标签
        taoLabelMap.put("中国500强","中国500强_new");//变更为自定义标签
        taoLabelMap.put("高收入","高收入_new");//变更为自定义标签
        taoLabelMap.put("高提成","高提成"); //无变动
        taoLabelMap.put("行业领先入","行业领先入_new");//变更为自定义标签
        taoLabelMap.put("人性化管理","人性化管理_new");//变更为自定义标签
        taoLabelMap.put("免费培训","免费培训"); //无变动
        taoLabelMap.put("储备干部","储备干部_new");//变更为自定义标签
        taoLabelMap.put("管理","管理_new");//变更为自定义标签
        taoLabelMap.put("定期户外活动","定期户外活动_new");//变更为自定义标签
        taoLabelMap.put("良性竞争机制","良性竞争机制_new");//变更为自定义标签
        taoLabelMap.put("定期培训","免费培训");
        taoLabelMap.put("岗位竞聘","岗位竞聘_new");//变更为自定义标签
        taoLabelMap.put("有乒乓球桌","有乒乓球桌_new");//变更为自定义标签
        taoLabelMap.put("免费图书馆","免费图书馆_new");//变更为自定义标签
        taoLabelMap.put("企业商学院","企业商学院_new");//变更为自定义标签
        taoLabelMap.put("带薪旅游","免费旅游");
        taoLabelMap.put("年终分红","年终奖");
        taoLabelMap.put("季度奖金","季度奖");
        taoLabelMap.put("生日祝福及礼物","生日礼物");
        taoLabelMap.put("年终抽奖","年终抽奖_new");//变更为自定义标签
        taoLabelMap.put("节假日发放礼品","节日福利");
        taoLabelMap.put("年底双薪","年终奖");
        taoLabelMap.put("工作自由","工作自由_new");//变更为自定义标签
        taoLabelMap.put("涉外岗位","涉外岗位_new");//变更为自定义标签
        taoLabelMap.put("SOHO",null);//删除该标签


        //详细参见文档 http://192.168.8.27:3000/projects/zhipin/wiki
        //        【原】(0, ("面议", "Negotiable"));            ----->【新】 (0,0)  Negotiable=1
        //        【原】(1, ("1500以下", "<1500"));           ----->【新】 (0,1499)
        //        【原】(2, ("1500-1999", "1500-1999"));       ----->【新】 (1500,1999)
        //        【原】(3, ("2000-2999", "2000-2999"));       ----->【新】 (2000,2999)
        //        【原】(4, ("3000-4499", "3000-4499"));       ----->【新】 (3000,4499)
        //        【原】(5, ("4500-5999", "4500-5999"));       ----->【新】 (4500,5999)
        //        【原】(6, ("6000-7999", "6000-7999"));       ----->【新】 (6000,7999)
        //        【原】(7, ("8000-9999", "8000-9999"));       ----->【新】 (8000,9999)
        //        【原】(8, ("10000-14999", "10000-14999"));   ----->【新】 (10000,14999)
        //        【原】(9, ("15000-19999", "15000-19999"));   ----->【新】 (15000,19999)
        //        【原】(10, ("20000-29999", "20000-29999"));  ----->【新】 (20000,29999)
        //        【原】(11, ("30000-49999", "30000-49999"));  ----->【新】 (30000,49999)
        //        【原】(12, ("50000及以上", ">=50000"));     ----->【新】 (50000,100000)

        salaryMap.put(-1,new Integer[]{0,0}); //因为老数据存在这种情况
        salaryMap.put(0,new Integer[]{0,0});
        salaryMap.put(1,new Integer[]{0,1499});
        salaryMap.put(2,new Integer[]{1500,1999});
        salaryMap.put(3,new Integer[]{2000,2999});
        salaryMap.put(4,new Integer[]{3000,4499});
        salaryMap.put(5,new Integer[]{4500,5999});
        salaryMap.put(6,new Integer[]{6000,7999});
        salaryMap.put(7,new Integer[]{10000,14999});
        salaryMap.put(8,new Integer[]{10000,14999});
        salaryMap.put(9,new Integer[]{15000,19999});
        salaryMap.put(10,new Integer[]{20000,29999});
        salaryMap.put(11,new Integer[]{30000,49999});
        salaryMap.put(12,new Integer[]{50000,100000});
    }

}
