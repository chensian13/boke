package csa.stu.app.userwork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("csa.stu.app.userwork.dao")
@EnableTransactionManagement
@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"csa.stu.app.common","csa.stu.app.userwork"})
public class UserWorkApp {

    public static void main(String[] args){
        SpringApplication.run(UserWorkApp.class,args);
    }


}
