package cn.sgz.springcloud.service;

import cn.sgz.springcloud.entity.SgzEntity;

import java.util.List;

/**
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/7 20:28
 */

public interface ProductService {
    boolean add(SgzEntity sgzEntity);
    SgzEntity get(Integer id);
    List<SgzEntity> list();
}
