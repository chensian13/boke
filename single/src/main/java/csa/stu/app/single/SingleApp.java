package csa.stu.app.single;

import csa.stu.app.common.config.SimpleConfig;
import csa.stu.app.common.util.UserinfoRequestUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.client.ConfigClientAutoConfiguration;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClientConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("csa.stu.app.single.dao")
@EnableTransactionManagement
@SpringBootApplication(exclude = {
        EurekaDiscoveryClientConfiguration.class,
        ConfigClientAutoConfiguration.class,
        EurekaClientAutoConfiguration.class})
@ComponentScan(value = {"csa.stu.app.common","csa.stu.app.single"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {SimpleConfig.class, UserinfoRequestUtil.class})})
public class SingleApp {

    public static void main(String[] args){
        SpringApplication.run(SingleApp.class,args);
    }


}
