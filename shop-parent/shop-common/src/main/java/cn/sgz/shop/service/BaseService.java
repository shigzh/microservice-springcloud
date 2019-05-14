package cn.sgz.shop.service;

import cn.sgz.shop.constants.ShopConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/12 13:39
 */

public class BaseService {
    // 封装成功
    public Map<String, Object> setResultSuccess() {
        return setResult(ShopConstants.HTTP_RES_CODE_200, ShopConstants.HTTP_RES_CODE_200_VALUE, null);
    }

    public Map<String, Object> setResultData(Object data) {
        return setResult(ShopConstants.HTTP_RES_CODE_200, ShopConstants.HTTP_RES_CODE_200_VALUE, data);
    }

    // 失败
    public Map<String, Object> setResultError(String msg) {
        return setResult(ShopConstants.HTTP_RES_CODE_500, msg, null);
    }

    // 自定义
    public Map<String, Object> setResult(Integer code, String msg, Object data) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put(ShopConstants.HTTP_RES_CODE_NAME, code);
        resultMap.put(ShopConstants.HTTP_RES_CODE_MSG, msg);
        if (data != null)
            resultMap.put(ShopConstants.HTTP_RES_CODE_DATA, data);
        return resultMap;
    }
}
