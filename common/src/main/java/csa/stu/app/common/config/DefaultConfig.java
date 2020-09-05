package csa.stu.app.common.config;

import csa.stu.util.ap.mvc.plus.AdviceController;
import csa.stu.util.ap.web_helper.cors.CorsFilter;
import csa.stu.util.ap.web_helper.token.TokenUtil;
import csa.stu.util.ap.web_helper.token.TokenUtilDefault;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultConfig {

    @Bean
    public AdviceController adviceController(){
        return new AdviceController();
    }

    @Bean
    public TokenUtilDefault tokenUtilDefault(){
        return new TokenUtilDefault();
    }

    @Bean
    public CorsFilter corsFilter(){
        return new CorsFilter();
    }

}
