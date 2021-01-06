package csa.stu.app.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.JedisPoolConfig;
import java.util.HashSet;
import java.util.Set;

/**
 * 哨兵机制：https://blog.csdn.net/u012240455/article/details/81843714
 * 参考：https://blog.csdn.net/J080624/article/details/86370718
 * https://blog.csdn.net/qq_24005787/article/details/81612759
 */
@Configuration
@PropertySource(value = "redis.properties")
public class RedisConfig {
    @Value("${redis.sentinel.nodes}")
    private String nodes;
    @Value("${redis.sentinel.master}")
    private String master;
    @Value("${csa.redis:false}")
    private boolean open; // 是否开启redis
    
    @Value("${redis.maxIdle}")
    private Integer maxIdle;

    @Value("${redis.maxTotal}")
    private Integer maxTotal;

    @Value("${redis.maxWaitMillis}")
    private Integer maxWaitMillis;

    @Value("${redis.minEvictableIdleTimeMillis}")
    private Integer minEvictableIdleTimeMillis;

    @Value("${redis.numTestsPerEvictionRun}")
    private Integer numTestsPerEvictionRun;

    @Value("${redis.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;

    @Value("${redis.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${redis.testWhileIdle}")
    private boolean testWhileIdle;
    
    
    
    /**
     * 实例化 RedisTemplate 对象
     * RedisTemplate是Spring Data Redis提供给用户的最高级的抽象客户端
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> functionDomainRedisTemplate() {
    	if(!open) return null;
    	RedisConnectionFactory redisConnectionFactory = jedisConnectionFactory();
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 设置数据存入 redis 的序列化方式,并开启事务
        // 如果不配置Serializer，那么存储的时候缺省使用String，如果用User类型存储，那么会提示错误User can't cast to String
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(stringRedisSerializer);
        // 开启事务
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
    
    
    /**
     * JedisPoolConfig 连接池
     *
     * @return
     */
    private JedisPoolConfig jedisPoolConfig(){
    	JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    	// 最大空闲数
        jedisPoolConfig.setMaxIdle(maxIdle);
        // 连接池的最大数据库连接数
        jedisPoolConfig.setMaxTotal(maxTotal);
        // 最大建立连接等待时间
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
        jedisPoolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        // 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
        jedisPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        // 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        // 是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        // 在空闲时检查有效性, 默认false
        jedisPoolConfig.setTestWhileIdle(testWhileIdle);
        return jedisPoolConfig;
    }

    /**
     * 配置redis的哨兵
     *
     */
    private RedisSentinelConfiguration sentinelConfiguration() {
        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
        String[] ns = nodes.split(",");
        Set<RedisNode> redisNodeSet = new HashSet<>();
        String[] t = null;
        for(String n: ns){
        	t = n.split(":");
        	// 配置redis的哨兵sentinel
            RedisNode senRedisNode = new RedisNode(t[0], Integer.parseInt(t[1]));
            redisNodeSet.add(senRedisNode);
        }
        redisSentinelConfiguration.setSentinels(redisNodeSet);
        redisSentinelConfiguration.setMaster(master);
        return redisSentinelConfiguration;
    }

    
    /**
     * 配置工厂
     *
     * @param jedisPoolConfig
     * @return
     */
    private JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(sentinelConfiguration(), jedisPoolConfig());
        return jedisConnectionFactory;
    }

    
    
    

    

}
