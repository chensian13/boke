package csa.stu.app.bk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan({"csa.stu.app.bk.**.dao"})
@EnableTransactionManagement
@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan({"csa.stu.app.bk","csa.stu.app.common"})
public class BokeKeeperApp {

    public static void main(String[] args){
        SpringApplication.run(BokeKeeperApp.class,args);
    }


}
