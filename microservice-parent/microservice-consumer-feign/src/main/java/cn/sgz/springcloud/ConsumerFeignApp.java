package cn.sgz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Feign 默认集成了 Ribbon 实现了客户端负载均衡调用
 * 使用 Feign 只需要定义一个接口，然后在接口上添加注解即可。
 */
//会扫描标记了指定包下@FeignClient注解的接口，并生成此接口的代理对象
@EnableFeignClients(basePackages= {"cn.sgz.springcloud"})
@EnableEurekaClient
@SpringBootApplication
public class ConsumerFeignApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApp.class, args);
    }

}
