package cn.sgz.springcloud;

/**
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/10 10:44
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaServer服务器端启动类,接受其它微服务注册进来
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer_Config_6001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_Config_6001.class,args);
    }
}
