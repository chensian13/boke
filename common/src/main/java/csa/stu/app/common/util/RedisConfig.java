package csa.stu.app.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * 参考：https://blog.csdn.net/J080624/article/details/86370718
 */
@Configuration
@PropertySource("classpath:redis.properties")
public class RedisConfig {
    @Value("${spring.redis.sentinel.nodes}")
    private String node;
    @Value("${spring.redis.sentinel.master}")
    private String master;

    @Bean
    public JedisSentinelPool jedisSentinelPool() {
        Set<String> sentinels = new HashSet<>();
        sentinels.add(node);
        return new JedisSentinelPool(master, sentinels);
    }


}
