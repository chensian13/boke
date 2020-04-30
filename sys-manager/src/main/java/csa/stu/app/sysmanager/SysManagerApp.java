package csa.stu.app.sysmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("csa.stu.app.sysmanager.dao")
@EnableTransactionManagement
@SpringBootApplication
@EnableEurekaClient
public class SysManagerApp {

    public static void main(String[] args){
        SpringApplication.run(SysManagerApp.class,args);
    }


}
