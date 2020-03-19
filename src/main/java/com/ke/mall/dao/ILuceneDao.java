package com.ke.mall.dao;

import com.ke.mall.entity.PageQuery;
import com.ke.mall.model.Brand;
import org.apache.lucene.queryparser.classic.ParseException;

import java.io.IOException;
import java.util.List;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/3/1 16:27
 */
public interface ILuceneDao {
    /**
     * 创建索引
     * @param brandList
     * @throws IOException
     */
    public void createBrandIndex(List<Brand> brandList) throws IOException;
    /**
     * 查询索引
     * @param pageQuery
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public PageQuery<Brand> searchBrand(PageQuery<Brand> pageQuery) throws IOException, ParseException;
    /**
     * 添加一个新索引
     * @param brand
     * @throws IOException
     */
    public void addBrandIndex(Brand brand) throws IOException;
    /**
     * 通过id删除商品索引
     * @param id
     * @throws IOException
     */
    public void deleteBrandIndexById(String id) throws IOException;
}
