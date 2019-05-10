package cn.sgz.springcloud.service;

import cn.sgz.springcloud.entity.SgzEntity;
import cn.sgz.springcloud.mapper.SgzMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/7 20:29
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private SgzMapper sgzMapper;

    @Override
    public boolean add(SgzEntity sgzEntity) {
        return sgzMapper.addProduct(sgzEntity);
    }

    @Override
    public SgzEntity get(Integer id) {
        SgzEntity sgzEntity= sgzMapper.findById(id);
        return sgzEntity;
    }

    @Override
    public List<SgzEntity> list() {
        return sgzMapper.findAll();
    }
}
