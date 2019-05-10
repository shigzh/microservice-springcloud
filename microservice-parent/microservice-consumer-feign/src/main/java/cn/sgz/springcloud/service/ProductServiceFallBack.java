package cn.sgz.springcloud.service;

import cn.sgz.springcloud.entity.SgzEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/9 14:32
 */
@Component
public class ProductServiceFallBack implements ProductService{
    @Override
    public SgzEntity get(Integer id) {
        return new SgzEntity(id,"故障错误3",new Date(),"error");
    }

    @Override
    public List<SgzEntity> list() {
        return null;
    }

    @Override
    public boolean add(SgzEntity product) {
        return false;
    }
}
