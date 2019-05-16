package cn.sgz.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/15 20:14
 */
@Getter
@Setter
@Slf4j
public class BaseEntity {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 更新时间
     */
    private Date updated;

}
