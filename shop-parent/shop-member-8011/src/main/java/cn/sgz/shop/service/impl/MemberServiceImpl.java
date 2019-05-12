package cn.sgz.shop.service.impl;

import cn.sgz.shop.service.MemberService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/12 12:28
 */
@RestController
public class MemberServiceImpl implements MemberService {
    @Override
    public String demo() {
        return "demo";
    }
}
