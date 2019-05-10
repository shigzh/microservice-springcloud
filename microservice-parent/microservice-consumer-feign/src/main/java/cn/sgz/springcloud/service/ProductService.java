package cn.sgz.springcloud.service;

import cn.sgz.springcloud.entity.SgzEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 使用 @FeignClient("服务名称") 注解标识，来指定调用哪个服务
 * 适用于接口开发的应用，如果不使用接口开发，请使用Ribbon+RestTemplate
 *
 * 这里的fallback = ProductServiceFallBack.class 是为了熔断机制hystrix
 * 如果这里配置了，product提供者类中就不需要添加了 @HystrixCommand(fallbackMethod = "getFallback")这个注解了
 *
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/8 17:23
 */
//指定调用的服务 MICROSERVICE-PRODUCT
@FeignClient(value = "microservice-product",fallback = ProductServiceFallBack.class)
public interface ProductService {
    @RequestMapping(value = "/product/get/{id}",method = RequestMethod.GET)
    SgzEntity get(@PathVariable("id") Integer id);
    @RequestMapping(value = "/product/list",method = RequestMethod.GET)
    List<SgzEntity> list();
    @RequestMapping(value = "/product/add",method = RequestMethod.POST)
    boolean add(SgzEntity product);
}
