package cn.sgz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Zuul 包含了对请求路由和校验过滤两个最主要的功能：
 * 其中路由功能负责将外部请求转发到具体的微服务实例上，是实现外部访问统一入口的基础，
 * 客户端请求网关/api/product，通过路由转发到 product 服务
 * 客户端请求网关/api/order，通过路由转发到 order 服务
 * 而过滤功能则负责对请求的处理过程进行干预，是实现请求校验等功能的基础.
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/9 16:25
 */
@EnableZuulProxy //开启zuul的功能
@SpringBootApplication
public class ZuulServer_7001 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServer_7001.class,args);
    }
}
