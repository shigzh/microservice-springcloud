package cn.sgz.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description: Spring Cloud服务注册中心
 * @Auther:shigzh
 * @create 2019/5/12 11:19
 */
@EnableEurekaServer //标识一个Eureka Server服务注册中心，接受其它微服务注册进来
@SpringBootApplication
public class ShopEurekaServer_6001 {
    public static void main(String[] args) {
        SpringApplication.run(ShopEurekaServer_6001.class, args);
    }
}
