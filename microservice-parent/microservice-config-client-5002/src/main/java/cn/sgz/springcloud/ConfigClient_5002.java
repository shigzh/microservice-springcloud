package cn.sgz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * application.yml 是用户级别的配置项
 * bootstrap.yml 是系统级别的配置项，优先级更高
 *
 * Spring Cloud 会创建一个 Bootstrap Context ， Bootstrap Context 会负责从外部资源加载配置属性并解析
 * 配置； Bootstrap 属性有高优先级，默认情况下，它们不会被本地配置覆盖。
 *
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/9 19:13
 */
@SpringBootApplication
public class ConfigClient_5002 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient_5002.class,args);
    }
}
