package cn.sgz.springcloud.controller;

import cn.sgz.springcloud.entity.SgzEntity;
import cn.sgz.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/7 20:32
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService sgzService;

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public boolean add(@RequestBody SgzEntity sgzEntity) {
        return sgzService.add(sgzEntity);
    }

    //当get方法出现异常时，则会调用hystrixGet方法处理
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用 @HystrixCommand 注解中 fallbackMethod属性指定的当前类中的方法
    //@HystrixCommand(fallbackMethod = "getFallback") 使用feign 接口的话这个就不用了
    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public SgzEntity get(@PathVariable("id") Integer id) {
        SgzEntity sgzEntity= sgzService.get(id);
        //模拟异常
        if(sgzEntity == null) {
            throw new RuntimeException("ID=" + id + "无效");
        }
        return sgzEntity;
    }
    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<SgzEntity> list() {
        return sgzService.list();
    }

    //当get方法出现异常时，则会调用此方法. 注意此方法的返回值，参数列表与原方法一致
//    public SgzEntity getFallback(@PathVariable("id") Integer id) {
//        System.out.println("故障错误==2==="+id);
//        //SgzEntity(Integer id, String userName, Date date, String dbSource)
//        return new SgzEntity(id,"故障错误2",new Date(),"error");
//    }
}
