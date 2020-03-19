package com.ke.mall.entity;

import java.io.Serializable;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/3/1 15:51
 */
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 返回code
     */
    private int code;
    /**
     * 返回message
     */
    private String msg;
    /**
     * 返回值
     */
    private T data;

    public ResultBean() {

    }

    public ResultBean(int code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
