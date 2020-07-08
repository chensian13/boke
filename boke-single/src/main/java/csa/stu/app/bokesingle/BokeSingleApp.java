package csa.stu.app.bokesingle;

import csa.stu.app.common.config.SimpleConfig;
import csa.stu.app.common.util.UserinfoRequestUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.client.ConfigClientAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClientConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("csa.stu.app.single.dao")
@EnableTransactionManagement
@SpringBootApplication(exclude = {
        EurekaDiscoveryClientConfiguration.class,
        ConfigClientAutoConfiguration.class,
        EurekaClientAutoConfiguration.class})
@ComponentScan(value = {"csa.stu.app.common","csa.stu.app.single","csa.stu.app.bokesingle"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {SimpleConfig.class, UserinfoRequestUtil.class})})
public class BokeSingleApp {

    public static void main(String[] args){
        SpringApplication.run(BokeSingleApp.class,args);
    }


}
