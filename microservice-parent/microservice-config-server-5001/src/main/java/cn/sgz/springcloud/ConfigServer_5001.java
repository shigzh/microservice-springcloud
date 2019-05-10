package cn.sgz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * $ cd microservice-cloud-config
 * # 添加到暂存区
 * $ git add microservice-config-application.yml
 * # 提交到本地库
 * $ git commit -m "first commit" microservice-config-application.yml
 * # 推送到远程库origin 的 master 主分支上
 * $ git push origin master
 *
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/9 17:28
 */
@EnableConfigServer //开启配置中心功能
@SpringBootApplication
public class ConfigServer_5001 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer_5001.class, args);
    }
}
