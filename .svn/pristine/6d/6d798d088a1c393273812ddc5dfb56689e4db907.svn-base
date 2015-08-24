package com.job5156.common.util;

/**
 * 用于职位和简历ID和编号之间的转换
 */
public class KeyMaskUtil {

    /**
     * 生成新的id主键, 高8位表示职位类别(最多7种),低32位表示职位的真实id(最大的职位id是268435455)，否则会溢出
     * @param posId
     * @param posType 1:网络职位，2:招聘会，3:招聘报
     * @return
     */
    public static int posIdToNo(int posId, short posType){
        long _posType = (long)posType << 28;
        long result = _posType|posId;
        return (int)result;
    }

    /**
     * 从返回的职位luceneId中提取posid和posType
     * @param posNo
     * @return
     */
    public static int[]  posNoToIdAndType(long posNo){
        int[] idAndType = new int[2];
        idAndType[0] = (int) ((posNo << 36) >> 36);
        idAndType[1] = (int) (posNo >> 28);
        return idAndType;
    }

    public static long resumeIdToNo(int resumeId) {
        return resumeId * 102;
    }

    public static int resumeNoToId(long resumeNo) {
        return (int)(resumeNo / 102);
    }

    /**
	 * 计算职位ID对应保存的REDIS区域前缀
	 * @param posId
	 * @return
	 */
	public static int calPosIdRedisRegion(int posId){
		return posId % 100;
	}
}
