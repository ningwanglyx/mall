package com.ke.mall.service;

import com.ke.mall.model.Brand;

import java.util.List;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/3/1 16:13
 */
public interface IBrandService {
    /**
     * 根据id获取品牌
     * @param id
     * @return
     */
    Brand getBrandById(Long id);

    /**
     * 获取所有品牌
     * @return
     */
    List<Brand> getAllBrand();

    /**
     * 增加品牌
     * @param brand
     */
    void addBrand(Brand brand);

    /**
     * 删除品牌
     * @param id
     */
    void deleteBrand(Long id);

    /**
     * 更新品牌
     * @param brand
     */
    void updateBrand(Brand brand);


}
