package csa.stu.app.common.config;

import csa.stu.util.ap.mvc.plus.AdviceController;
import csa.stu.util.ap.web_helper.cors.CorsFilter;
import csa.stu.util.ap.web_helper.token.TokenUtil;
import csa.stu.util.ap.web_helper.token.TokenUtilDefault;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DefaultConfig {

    @Bean
    public TokenUtilDefault tokenUtilDefault(){
        return new TokenUtilDefault();
    }

    @Bean
    public CorsFilter corsFilter(){
        return new CorsFilter();
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(3000);
        requestFactory.setReadTimeout(3000);
        return new RestTemplate(requestFactory);
    }

}
