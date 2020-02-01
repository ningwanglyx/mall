package com.ke.mall.service;

/**
 * @Summary: redis操作String的Service，对象和数组都以json形式存储
 * @Author: YangxingLiu
 * @Since: 2020/1/19 11:32
 */
public interface IStringRedisService {
    /**
     * 存储数据
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 获取数据
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置超期时间
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     * @param key
     */
    void remove(String key);

    /**
     * 自增操作
     * @param key
     * @param delta 指针步长
     * @return
     */
    Long increment(String key, long delta);

}
