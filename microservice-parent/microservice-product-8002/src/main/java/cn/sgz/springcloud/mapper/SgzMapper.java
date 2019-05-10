package cn.sgz.springcloud.mapper;


import cn.sgz.springcloud.entity.SgzEntity;

import java.util.List;

public interface SgzMapper {

    SgzEntity findById(Integer pid);

    List<SgzEntity> findAll();

    boolean addProduct(SgzEntity product);
}