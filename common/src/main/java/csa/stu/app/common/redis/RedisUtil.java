package csa.stu.app.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

@Component
public class RedisUtil {
    @Autowired(required = false)
    private JedisSentinelPool jedisSentinelPool;
    @Value("${csa.redis:false}")
    private boolean open; //是否开启redis

    //封装方法  get
    public String get(String key) {
        if(!open) return null;
        Jedis jedis = jedisSentinelPool.getResource();
        String result = jedis.get(key);
        jedis.close();
        return result;
    }

    //封装方法  get
    public void set(String key,String value) {
        if(!open) return ;
        Jedis jedis = jedisSentinelPool.getResource();
        String result = jedis.set(key,value);
        jedis.close();
    }

    //封装方法  del
    public void del(String key) {
        if(!open) return ;
        Jedis jedis = jedisSentinelPool.getResource();
        jedis.del(key);
        jedis.close();
    }


}
