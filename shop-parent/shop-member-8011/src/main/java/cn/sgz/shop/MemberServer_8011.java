package cn.sgz.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/12 12:48
 */
//扫描mybatis的mapper接口文件
@MapperScan(value="cn.sgz.shop.mapper")
//向服务注册中心进行注册
@EnableEurekaClient //本服务启动后会自动注册进Eureka中心
@SpringBootApplication
public class MemberServer_8011 {
    public static void main(String[] args) {
        SpringApplication.run(MemberServer_8011.class,args);
    }
}
