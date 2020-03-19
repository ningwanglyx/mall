package com.ke.mall.entity;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/3/1 15:49
 */
public class PageInfo {
    /**
     * 当前页数
     */
    private int pageNum;

    /**
     * 每页条数
     */
    private int pageSize;
    /**
     * 总数
     */
    private long total;


    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }

}
