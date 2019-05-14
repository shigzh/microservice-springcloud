package cn.sgz.shop.utils;

import java.io.Serializable;

/**
 * 自定义响应结构
 */
public class DataResult implements Serializable{
	private static final long serialVersionUID = 7489757118341880750L;
    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static DataResult build(Integer status, String msg, Object data) {
        return new DataResult(status, msg, data);
    }

    public static DataResult ok(Object data) {
        return new DataResult(data);
    }

    public static DataResult ok() {
        return new DataResult(null);
    }

    public static DataResult build(Integer status, String msg) {
        return new DataResult(status, msg, null);
    }
    
    public static DataResult buildError(String msg) {
        return new DataResult(500, msg, null);
    }
    
    public DataResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public DataResult(Object data) {
        this.status = 200;
        this.msg = "success";
        this.data = data;
    }

}
