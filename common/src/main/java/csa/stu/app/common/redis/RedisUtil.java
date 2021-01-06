package csa.stu.app.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * 哨兵模式
 * @author csa
 *
 */
@Component
public class RedisUtil {
    @Autowired(required = false)
    private RedisTemplate redisTemplate;

    //封装方法  get
    public String get(String key) {
        if(redisTemplate==null) return null;
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    //封装方法  get
    public void set(String key,String value) {
    	if(redisTemplate==null) return ;
    	ValueOperations<String, String> operations = redisTemplate.opsForValue();
    	operations.set(key, value);
    }

    //封装方法  del
    public void del(String key) {
    	if(redisTemplate==null) return ;
    	redisTemplate.delete(key);
    }

    
    public boolean isOpen() {
		return redisTemplate!=null;
	}

}
