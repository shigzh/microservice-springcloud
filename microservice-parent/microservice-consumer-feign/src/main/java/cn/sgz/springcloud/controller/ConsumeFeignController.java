package cn.sgz.springcloud.controller;

import cn.sgz.springcloud.entity.SgzEntity;
import cn.sgz.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/8 9:46
 */
@RestController
public class ConsumeFeignController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/consumer/product/add")
    public boolean add(SgzEntity sgzEntity) {
        return productService.add(sgzEntity);
    }
    @RequestMapping(value = "/consumer/product/get/{id}")
    public SgzEntity get(@PathVariable("id") Integer id) {
        System.out.println("get调用开始===dfd==》"+id);
        SgzEntity sgzEntity= productService.get(id);
        System.out.println(sgzEntity+"......");
        System.out.println("get调用结束=====》"+id);
        return sgzEntity;
    }
    @RequestMapping(value = "/consumer/product/list")
    public List<SgzEntity> list() {
        return productService.list();
    }
}
