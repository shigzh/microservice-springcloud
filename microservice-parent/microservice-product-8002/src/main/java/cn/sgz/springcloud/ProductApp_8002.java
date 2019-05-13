package cn.sgz.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/7 20:35
 */
//@EnableHystrix //开启 Hystrix 熔断机制的支持
//扫描mybatis的mapper接口文件
@MapperScan(value="cn.sgz.springcloud.mapper")
////向服务注册中心进行注册
@EnableEurekaClient //本服务启动后会自动注册进Eureka服务中心
@SpringBootApplication
public class ProductApp_8002 {
    public static void main(String[] args) {
        SpringApplication.run(ProductApp_8002.class, args);
    }

}
