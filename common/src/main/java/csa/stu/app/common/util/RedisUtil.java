package csa.stu.app.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

public class RedisUtil {
    private JedisSentinelPool jedisSentinelPool;

    public RedisUtil(JedisSentinelPool jedisSentinelPool) {
        this.jedisSentinelPool = jedisSentinelPool;
    }

    //封装方法  get
    public String get(String key) {
        Jedis jedis = jedisSentinelPool.getResource();
        String result = jedis.get(key);
        jedis.close();
        return result;
    }

    //封装方法  get
    public void set(String key,String value) {
        Jedis jedis = jedisSentinelPool.getResource();
        String result = jedis.set(key,value);
        jedis.close();
    }

    //封装方法  del
    public void del(String key) {
        Jedis jedis = jedisSentinelPool.getResource();
        jedis.del(key);
        jedis.close();
    }


}
