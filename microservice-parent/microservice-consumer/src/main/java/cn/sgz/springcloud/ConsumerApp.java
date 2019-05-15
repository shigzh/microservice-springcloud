package cn.sgz.springcloud;

import cn.sgz.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
//如果有多个服务，为某一个服务定制负载均衡策略，其他服务使用公共的
//这里microservice-product服务使用MySelfRule配置里的均衡策略，其他服务使用ConfigBean配置的均衡策略
@RibbonClient(name = "microservice-product",configuration = MySelfRule.class)
@EnableEurekaClient
@SpringBootApplication
public class ConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class, args);
    }

}
