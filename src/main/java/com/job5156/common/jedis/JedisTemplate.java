package com.job5156.common.jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisException;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.job5156.common.exception.SerializeException;
import com.job5156.common.util.SerializeUtil;

/**
 * REDIS操作模板类
 * @author leo
 *
 */
public class JedisTemplate {
	private static Logger logger = Logger.getLogger(JedisTemplate.class);
	
	private JedisPool jedisPool;

	public JedisTemplate(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
	
	public JedisPool getJedisPool() {
		return jedisPool;
	}
	
	/**
	 * 有返回结果的回调接口定义
	 */
	public interface JedisAction<T> {
		T action(Jedis jedis) throws SerializeException;
	}

	/**
	 * 无返回结果的回调接口定义
	 */
	public interface JedisActionNoResult {
		void action(Jedis jedis) throws SerializeException;
	}
	
	/**
	 * 是否存在key, 如果key存在返回true, 否则返回false
	 * @param key
	 * @return
	 */
	public boolean isKeyExist(final String key){
		return execute(new JedisAction<Boolean>() {

			@Override
			public Boolean action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				return jedis.exists(redisKey);
			}
		});
	}
	
	/**
	 * 判断value值是否存在redis的set中
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean isInSet(final String key, final String value){
		return execute(new JedisAction<Boolean>() {

			@Override
			public Boolean action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				byte[] redisValue = SerializeUtil.serializeStr(value);
				
				if(jedis.exists(redisKey)){
					return jedis.sismember(redisKey, redisValue);
				}
				return false;
			}
		});
	}
	
	/**
	 * 删除key, 如果key存在返回true, 否则返回false。
	 */
	public boolean del(final String key) {
		return execute(new JedisAction<Boolean>() {

			@Override
			public Boolean action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				return jedis.del(redisKey) == 1 ? true : false;
			}
		});
	}
	
    /**
     * 将内容写入Redis，保存类型为String
     * @param key Key
     * @param value 内容
     */
    public void writeToString(final String key, final String value) {
    	execute(new JedisActionNoResult() {

			@Override
			public void action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				byte[] redisValue = SerializeUtil.serializeStr(value);
				jedis.set(redisKey, redisValue);
			}
        });
    }
	
    /**
     * 将内容从Redis的String类型中读取
     * @param key Key
     * @return 内容
     */
    public String readFromString(final String key) {
    	return execute(new JedisAction<String>() {

			@Override
			public String action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				byte[] redisValue = jedis.get(redisKey);
				return SerializeUtil.deserializeStr(redisValue);
			}
        });
    }
    
    /**
     * 将内容写入到Redis，保存类型为Map
     * @param key
     * @param map
     */
    public <T> boolean writeToMap(final String key, final Map<String, T> map){
    	return execute(new JedisAction<Boolean>() {

			@Override
			public Boolean action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				if(MapUtils.isNotEmpty(map)){
					for(Map.Entry<String, T> entry : map.entrySet()){
						byte[] fieldKey = SerializeUtil.serializeStr(entry.getKey());
						byte[] fieldVal = SerializeUtil.serializeObj(entry.getValue());
						jedis.hset(redisKey, fieldKey, fieldVal);
					}
				}
				return true;
			}
        });
    }
    
    public <T> boolean writeToMap(final String key, final String mapkey, final T mapVal){
    	return execute(new JedisAction<Boolean>() {

			@Override
			public Boolean action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				byte[] fieldKey = SerializeUtil.serializeStr(mapkey);
				byte[] fieldVal = SerializeUtil.serializeObj(mapVal);
				jedis.hset(redisKey, fieldKey, fieldVal);
				return true;
			}
        });
    }
   
    /**
     * 从Redis中读取Map结构数据并封装到Map对象返回
     * @param key
     * @param cla
     * @return
     */
    public <T> Map<String, T> readFromMap(final String key, final Class<T> cla){
    	return execute(new JedisAction<Map<String, T>>() {

			@Override
			public Map<String, T> action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				Map<String, T> map = Maps.newHashMap();
				
				Map<byte[], byte[]> byteMap = jedis.hgetAll(redisKey);
				if(MapUtils.isNotEmpty(byteMap)){
					for(Map.Entry<byte[], byte[]> entry : byteMap.entrySet()){
            			String fieldKey = SerializeUtil.deserializeStr(entry.getKey());
            			T t = (T)SerializeUtil.deserializeObj(entry.getValue(), cla);
            			map.put(fieldKey, t);
            		}
				}
				return map;
			}
        });
    }
    
    /**
     * 从Redis中读取Map结构中某一个key的数据并返回
     * @param key
     * @param mapKey
     * @param cla
     * @return
     */
    public <T> T readObjectFromMap(final String key, final String mapKey, final Class<T> cla){
		return execute(new JedisAction<T>() {

			@Override
			public T action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				byte[] fieldKey = SerializeUtil.serializeStr(mapKey);
				byte[] fieldVal = jedis.hget(redisKey, fieldKey);
				return (T)SerializeUtil.deserializeObj(fieldVal, cla);
			}
		});
    }
    
    /**
     * 从Redis的Map中移除某个key及value映射
     * @param key
     * @param mapKey
     * @return
     */
    public boolean removeFromMap(final String key, final String mapKey){
    	return execute(new JedisAction<Boolean>() {

			@Override
			public Boolean action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				byte[] fieldKey = SerializeUtil.serializeStr(mapKey);
				return jedis.hdel(redisKey, fieldKey) > 0;
			}
		});
    }
    
    /**
     * 从Redis读取MAP结构中的所有key
     * @param key
     * @return
     */
    public Set<String> readFieldsFromMap(final String key){
    	return execute(new JedisAction<Set<String>>(){

			@Override
			public Set<String> action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				if(jedis.exists(redisKey)){
					Set<byte[]> fieldSet = jedis.hkeys(redisKey);
					Set<String> dataSet = Sets.newHashSet();
					
					if(CollectionUtils.isNotEmpty(fieldSet)){
						for(byte[] fieldStr : fieldSet){
							dataSet.add(SerializeUtil.deserializeStr(fieldStr));
						}
					}
					return dataSet;
				}
				return null;
			}
    	});
    }
    
    /**
     * 判断REDIS中存储的MAP结构数据是否包含key=field的数据
     * @param key
     * @param field
     * @return
     */
    public boolean hExists(final String key, final String mapKey){
    	return execute(new JedisAction<Boolean>(){

			@Override
			public Boolean action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				byte[] fieldKey = SerializeUtil.serializeStr(mapKey);
				return jedis.hexists(redisKey, fieldKey);
			}
    		
    	});
    }
    
    /**
     * 将内容插入到Redis，保存类型为List
     * key不存在的话就创建，存在的话就append（lpush）
     * @param key Key
     * @param value 待写入的值
     * @return 成功写入返回true，否则返回false
     */
    public boolean writeToList(final String key, final String value) {
    	return execute(new JedisAction<Boolean>() {

			@Override
			public Boolean action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				byte[] redisValue = SerializeUtil.serializeStr(value);
				jedis.rpush(redisKey, redisValue);
				return true;
			}
        });
    }
    
    /**
     * 将内容插入到Redis，保存类型为List
     * 此方法只针对key不存在的情况，将list全部写入（所以用rpush的方法）
     * 如果key已经存在了，返回false
     * @param key Key
     * @param list 待写入的列表值
     * @return 成功写入返回true，否则返回false
     */
    public boolean writeToList(final String key, final List<String> list) {
    	return execute(new JedisAction<Boolean>() {

			@Override
			public Boolean action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				if(jedis.exists(redisKey)){
					return false;
				}else{
					for(String val : list){
						byte[] redisValue = SerializeUtil.serializeStr(val);
						jedis.rpush(redisKey, redisValue);
					}
					return true;
				}
			}
        });
    }
    
    /**
     * 将内容从Redis的List中读取
     * @param key Key
     * @return 返回对应的列表
     */
    public List<String> readFromList(final String key) {
    	return execute(new JedisAction<List<String>>() {

			@Override
			public List<String> action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				List<String> dataList = Lists.newArrayList();
				
				if(jedis.exists(redisKey)){
					List<byte[]> byteList = jedis.lrange(redisKey, 0, -1);
					for(byte[] bytes : byteList){
						dataList.add(SerializeUtil.deserializeStr(bytes));
					}
				}
				return dataList;
			}
        });
    }
    
    /**
     * 将对象列表写入REDIS
     * 如果KEY已经存在，先删除，然后再写入
     * @param key
     * @param list
     * @return
     */
    public <T> Boolean writeObjectToList(final String key, final List<T> list){
    	return execute(new JedisAction<Boolean>() {

			@Override
			public Boolean action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				//删除已经存在缓存
				del(key);

				if(CollectionUtils.isNotEmpty(list)){
					for(T t : list){
		    			byte[] redisValue = SerializeUtil.serializeObj(t);
		    			jedis.rpush(redisKey, redisValue);
	                }
				}
				return true;
            }
        });
    }   
    
    
    /**
     * 将内容推入队列，队列是类型为SortedSet的Redis数据结构
     * 用zAdd的方法
     * @param key Key
     * @param list 待写入的列表值
     */
    public boolean writeToZset(final String key, final List<String> list) {
    	return execute(new JedisAction<Boolean>() {

			@Override
			public Boolean action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				if(CollectionUtils.isNotEmpty(list)){
					for(String value : list){
						byte[] redisValue = SerializeUtil.serializeStr(value);
						jedis.zadd(redisKey, 0, redisValue);
					}
				}
				return true;
			}
        });
    }
    
    /**
     * 返回有序集sortedSet中，指定数量的元素列表
     * @param key
     * @param count
     * 			元素数量
     * @return
     */
    public List<String> readFromZset(final String key, final long count) {
        return readFromZset(key, 0, count - 1);
    }
    
    public List<String> readFromZset(final String key, final long begin, final long end){
    	return execute(new JedisAction<List<String>>() {

			@Override
			public List<String> action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				List<String> dataList = Lists.newArrayList();
				
				Set<byte[]> valueSet = jedis.zrange(redisKey, begin, end);
				if(CollectionUtils.isNotEmpty(valueSet)){
					for(byte[] value : valueSet){
						dataList.add(SerializeUtil.deserializeStr(value));
					}
				}
				return dataList;
			}
        });
    }
    
    /**
     * 从SortedSet中移除n条内容
     * @param key
     * @param valueList
     * @return
     */
    public void removeFromZset(final String key, final List<String> list){
    	execute(new JedisActionNoResult() {

			@Override
			public void action(Jedis jedis) throws SerializeException {
				byte[] redisKey = SerializeUtil.serializeStr(key);
				if(jedis.exists(redisKey) && CollectionUtils.isNotEmpty(list)){
					for(String value : list){
						byte[] redisValue = SerializeUtil.serializeStr(value);
						jedis.zrem(redisKey, redisValue);
					}
				}
			}
        });
    }
	
	/**
	 * 执行有返回结果的action。
	 */
	public <T> T execute(JedisAction<T> jedisAction) throws JedisException {
		Jedis jedis = null;
		boolean broken = false;
		try {
			jedis = jedisPool.getResource();
			return jedisAction.action(jedis);
		} catch (JedisConnectionException e) {
			logger.error("Redis connection lost.", e);
			broken = true;
			throw e;
		} catch (SerializeException e1){
			logger.error(e1.getMessage(), e1);
			return null;
		} finally {
			closeJedisResource(jedis, broken);
		}
	}

	/**
	 * 执行无返回结果的action。
	 */
	public void execute(JedisActionNoResult jedisAction) throws JedisException {
		Jedis jedis = null;
		boolean broken = false;
		try {
			jedis = jedisPool.getResource();
			jedisAction.action(jedis);
		} catch (JedisConnectionException e) {
			logger.error("Redis connection lost.", e);
			broken = true;
			throw e;
		} catch (SerializeException e1){
			logger.error(e1.getMessage(), e1);
		} finally {
			closeJedisResource(jedis, broken);
		}
	}
	
	/**
	 * 回收客户端资源
	 */
	private void closeJedisResource(Jedis jedis, boolean connectionBroken) {
		if (jedis != null) {
			if (connectionBroken) {
				jedisPool.returnBrokenResource(jedis);
			} else {
				jedisPool.returnResource(jedis);
			}
		}
	}
	

}
