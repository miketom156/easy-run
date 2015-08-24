package com.job5156.common.jedis;

import org.apache.commons.lang.StringUtils;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

import com.job5156.beans.ServerConfig;
import com.job5156.beans.ServerConfigLoader;

/**
 * Jedis配置
 * @author leo
 *
 */
public class JedisConfig {
	
	private String configName;		//REDIS服务器节点名称，详情见CommonEnum.RedisServer
	private String host;			//服务器IP
	private String port;			//服务器端口
	private String pass;			//服务器密码
	private Integer timeOut;		//超时时间
	private Integer maxIdle;		//最大空闲数量
	private Integer maxActive;		//最大活动数量

	private JedisPool jedisPool;
	private JedisPoolConfig jedisPoolConfig;

	public JedisConfig(String configName) {
		this.configName = configName;
		this.maxActive = 2;
		this.maxIdle = 2;
		this.timeOut = Protocol.DEFAULT_TIMEOUT;
		this.init();
	}

	public JedisConfig(String configName, int maxIdle, int maxActive, int timeOut) {
		this.configName = configName;
		this.maxIdle = maxIdle;
		this.maxActive = maxActive;
		this.timeOut = timeOut;
		this.init();
	}

	private void init(){
		jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxActive(maxActive);
		jedisPoolConfig.setTimeBetweenEvictionRunsMillis(-1);
		
		this.host = ServerConfigLoader.getConfigByName(ServerConfig.REDIS_HOST + configName);
		this.port = ServerConfigLoader.getConfigByName(ServerConfig.REDIS_PORT + configName);
		this.pass = ServerConfigLoader.getConfigByName(ServerConfig.REDIS_PASS + configName);
		
		if(StringUtils.isNotBlank(this.pass)){
			jedisPool = new JedisPool(jedisPoolConfig, this.host, Integer.valueOf(this.port), Integer.valueOf(this.timeOut), this.pass);
		}else{
			jedisPool = new JedisPool(jedisPoolConfig, this.host, Integer.valueOf(this.port), Integer.valueOf(this.timeOut));
		}
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Integer timeOut) {
		this.timeOut = timeOut;
	}

	public Integer getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
	}

	public Integer getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(Integer maxActive) {
		this.maxActive = maxActive;
	}

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	public JedisPoolConfig getJedisPoolConfig() {
		return jedisPoolConfig;
	}

	public void setJedisPoolConfig(JedisPoolConfig jedisPoolConfig) {
		this.jedisPoolConfig = jedisPoolConfig;
	}
}
