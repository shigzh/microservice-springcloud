package cn.sgz.shop.controller;

import cn.sgz.shop.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/14 10:06
 */
@RestController
public class TestController {
    @Autowired
    private RedisService redisService;
    /**
     * 公告列表
     */
    @RequestMapping(value="/testSet")
    public void testSet() {
        redisService.set("aaa","史高占",20L);
        System.out.println("我执行完毕了。。testSet。。");
        Object name = redisService.get("name");
        System.out.println(name);
    }
    /**
     * 公告列表
     */
    @RequestMapping(value="/testGet")
    public void testGet() {
        Object name = redisService.get("name");
        System.out.println(name);
        System.out.println("我执行完毕了。。testGet。。");
    }
}
