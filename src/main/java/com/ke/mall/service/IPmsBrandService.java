package com.ke.mall.service;

import com.github.pagehelper.PageInfo;
import com.ke.mall.model.PmsBrand;

import java.util.List;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/1/18 19:14
 */
public interface IPmsBrandService {
    /**
     * 列表查询
     * @return
     */
    List<PmsBrand> listAllBrand();

    /**
     * create new brand
     * @param brand
     * @return
     */
    int createBrand(PmsBrand brand);

    /**
     * update brand
     * @param brand
     */
    void updateBrand(PmsBrand brand);

    /**
     * delete a brand by id
     * @param id
     */
    void deleteBrand(Long id);

    /**
     * find a brand
     * @param id
     * @return
     */
    List<PmsBrand> findById(Long id);

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<PmsBrand> findByPage(int pageNum, int pageSize);



}