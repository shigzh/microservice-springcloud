package cn.sgz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/8 11:44
 */
@EnableEurekaServer //标识一个Eureka Server服务注册中心
@SpringBootApplication
public class EurekaServer_6002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_6002.class, args);
    }
}
