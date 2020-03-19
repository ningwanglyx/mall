package com.ke.mall.service.impl;

import com.ke.mall.entity.PageQuery;
import com.ke.mall.model.Brand;
import com.ke.mall.service.ILuceneService;

import java.io.IOException;
import java.text.ParseException;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/3/1 16:22
 */
public class LuceneService implements ILuceneService {
    @Override
    public void synBrandCreateIndex() throws IOException {

    }

    @Override
    public PageQuery<Brand> searchBrand(PageQuery<Brand> pageQuery) throws IOException, ParseException {
        return null;
    }
}
