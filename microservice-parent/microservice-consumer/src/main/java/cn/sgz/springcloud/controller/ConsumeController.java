package cn.sgz.springcloud.controller;

import cn.sgz.springcloud.entity.SgzEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/8 9:46
 */
@RestController
public class ConsumeController {
    //private static final String REST_URL_PREFIX = "http://127.0.0.1:8001"; //单机版
    //修改为Eureka注册中心的地址;可使用 服务名称 替代真实IP地址。服务名称 就是服务提供者在application.yml中配置的spring.application.name属性的值。
    //和 Eureka 整合后 ，消费者 Consumer 可以直接调用提供者服务，而不用再关心地址和端口号
    private static final String REST_URL_PREFIX = "http://microservice-product";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/product/add")
    public boolean add(SgzEntity sgzEntity) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/product/add",sgzEntity, Boolean.class);
    }
    @RequestMapping(value = "/consumer/product/get/{id}")
    public SgzEntity get(@PathVariable("id") Integer id) {
        System.out.println("get调用开始===dfd==》"+id);
        SgzEntity sgzEntity= restTemplate.getForObject(REST_URL_PREFIX + "/product/get/" + id,SgzEntity.class);
        System.out.println(sgzEntity+"......");
        System.out.println("get调用结束=====》"+id);
        return sgzEntity;
    }
    @RequestMapping(value = "/consumer/product/list")
    public List<SgzEntity> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/product/list",List.class);
    }
}
