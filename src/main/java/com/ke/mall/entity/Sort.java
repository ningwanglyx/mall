package com.ke.mall.entity;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/3/1 15:50
 */
public class Sort {
    /**
     * 字段名
     */
    private String field;
    /**
     * 升序,asc,desc
     */
    private String order;

    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    public String getOrder() {
        return order;
    }
    public void setOrder(String order) {
        this.order = order;
    }

}
