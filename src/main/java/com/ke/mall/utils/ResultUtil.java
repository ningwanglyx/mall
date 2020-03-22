package com.ke.mall.utils;

import com.ke.mall.entity.ResultBean;
import com.ke.mall.entity.ResultEnum;

/**
 * @Summary: 测试提交
 * @Author: YangxingLiu
 * @Since: 2020/3/1 15:54
 */
public class ResultUtil {
    public static <T> ResultBean<T> success(T t){
        ResultEnum successEnum = ResultEnum.SUCCESS;
        return new ResultBean<T>(successEnum.getCode(),successEnum.getMsg(),t);
    }

    public static <T> ResultBean<T> success(){
        return success(null);
    }

    public static <T> ResultBean<T> error(ResultEnum Enum){
        ResultBean<T> result = new ResultBean<T>();
        result.setCode(Enum.getCode());
        result.setMsg(Enum.getMsg());
        result.setData(null);
        return result;
    }
}
