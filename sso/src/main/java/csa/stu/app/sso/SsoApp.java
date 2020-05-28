package csa.stu.app.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan({"csa.stu.app.sso.dao"})
@EnableTransactionManagement
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan({"csa.stu.app.sso","csa.stu.app.common"})
public class SsoApp {

    public static void main(String[] args){
        SpringApplication.run(SsoApp.class,args);
    }


}
