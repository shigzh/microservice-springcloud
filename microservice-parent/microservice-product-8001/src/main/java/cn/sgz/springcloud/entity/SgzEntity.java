package cn.sgz.springcloud.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/7 17:51
 */

public class SgzEntity implements Serializable {
    //按alt+enter键 生成序列化id
    private static final long serialVersionUID = -3932087591646353874L;

    private Integer id; //主键
    private String userName; //名称
    private Date date;
    private String dbSource; // 来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

    public SgzEntity() {//必须包含一个无参构造器
    }

    public SgzEntity(String userName) {
        this.userName = userName;
    }

    public SgzEntity(Integer id, String userName, Date date, String dbSource) {
        this.id = id;
        this.userName = userName;
        this.date = date;
        this.dbSource = dbSource;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

    @Override
    public String toString() {
        return "SgzEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", date=" + date +
                ", dbSource='" + dbSource + '\'' +
                '}';
    }
}
