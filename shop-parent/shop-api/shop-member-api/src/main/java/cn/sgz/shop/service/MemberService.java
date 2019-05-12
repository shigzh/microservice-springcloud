package cn.sgz.shop.service;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/12 12:22
 */
public interface MemberService {
    @GetMapping("/demo")
    String demo();
}
