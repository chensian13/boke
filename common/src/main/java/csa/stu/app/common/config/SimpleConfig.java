package csa.stu.app.common.config;

import csa.stu.app.common.entity.User;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SimpleConfig {

    @Bean("myRestTemplate")
    @LoadBalanced // 需要使用负载均衡,必须与Bean一同使用
    public RestTemplate configRestTemplate(){
        return new RestTemplate();
    }




}
