package com.job5156.common.jedis;

import org.apache.commons.lang.StringUtils;

import com.job5156.common.CommonEnum.RedisServer;

/**
 * Jedis工厂类
 * @author leo
 *
 */
public class JedisFactory {

	private JedisConfig jedisConfig1;
	private JedisConfig jedisConfig2;
	
	private JedisTemplate jedisTemplateMaster1;
	private JedisTemplate jedisTemplateMaster2;
	
	public static JedisFactory getInstance(){
		return new JedisFactory();
	}
	
	public JedisFactory(){
		jedisConfig1 = new JedisConfig(RedisServer.MASTER1.getName());
		this.jedisTemplateMaster1 = new JedisTemplate(jedisConfig1.getJedisPool());
		
		jedisConfig2 = new JedisConfig(RedisServer.MASTER2.getName());
		this.jedisTemplateMaster2 = new JedisTemplate(jedisConfig2.getJedisPool());
	}
	
	/**
	 * 获取默认的redis服务器
	 * @return
	 */
	public JedisTemplate getDefaultJedisTemplate(){
		return jedisTemplateMaster1;
	}
	
	/**
	 * 根据rediskey判断使用哪台redis服务器
	 * @param key
	 * @return
	 */
	public JedisTemplate getJedisTemplate(String key){
		if(this.checkUsageOfMaster2(key)){
            return jedisTemplateMaster2;
        }
		return jedisTemplateMaster1;
	}
	
    /**
     * 判断是否使用master2服务器
     * @param key
     * @return
     */
    private boolean checkUsageOfMaster2(String key){
    	boolean checkFlag = StringUtils.contains(key, ":login:");
    	checkFlag = checkFlag || StringUtils.startsWith(key, "pos:access:ip:");
    	checkFlag = checkFlag || StringUtils.startsWith(key, "pos:analysis:");
    	checkFlag = checkFlag || StringUtils.startsWith(key, "pos:article:consultation:");
    	checkFlag = checkFlag || StringUtils.startsWith(key, "recommended:pos:id:");
    	return checkFlag;
    }
}
