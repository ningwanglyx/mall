package com.ke.mall.service;

import com.ke.mall.entity.PageQuery;
import com.ke.mall.model.Brand;

import java.io.IOException;
import java.text.ParseException;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/3/1 16:20
 */
public interface ILuceneService {
    /**
     * 启动后同步Brand表，并创建index
     * @throws IOException
     */
    void synBrandCreateIndex() throws IOException;

    PageQuery<Brand> searchBrand(PageQuery<Brand> pageQuery) throws IOException, ParseException;
}
