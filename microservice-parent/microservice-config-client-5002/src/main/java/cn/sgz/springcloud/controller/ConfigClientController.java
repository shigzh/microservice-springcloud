package cn.sgz.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/9 19:20
 */
@RestController
public class ConfigClientController {
    //会从github中的microservice-config-application.yml中获取
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private String port;
    //请求访问
    @RequestMapping("/config")
    public String getConfig() {
        String content = "applicationName:" + applicationName + ", port:" +port;
        System.out.println("content: " + content);
        return content;
    }
}
