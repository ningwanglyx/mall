package com.ke.mall.dao.impl;

import com.ke.mall.dao.ILuceneDao;
import com.ke.mall.entity.PageQuery;
import com.ke.mall.model.Brand;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.SearcherManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/3/1 16:28
 */
//@Repository
public class LuceneDao implements ILuceneDao {
    @Autowired
    private IndexWriter indexWriter;
    @Autowired
    private Analyzer analyzer;
    @Autowired
    private SearcherManager searcherManager;

    /**
     * 创建品牌索引
     * @param brandList
     * @throws IOException
     */
    @Override
    public void createBrandIndex(List<Brand> brandList) throws IOException {
        List<Document> documents = new ArrayList<>();
        brandList.stream().forEach(brand -> {
            Document document = new Document();
            document.add(new StringField("id", brand.getId().toString() + "", Field.Store.YES));
            document.add(new StringField("name", brand.getName() + "", Field.Store.YES));
            document.add(new TextField("brandStory", brand.getBrandStory(), Field.Store.YES));
            //建立倒排索引
            document.add(new IntPoint("sort", brand.getSort()));


            //存储到索引库
            document.add(new StoredField("sort", brand.getSort()));
            documents.add(document);
        });
        indexWriter.addDocuments(documents);
        indexWriter.commit();

    }

    @Override
    public PageQuery<Brand> searchBrand(PageQuery<Brand> pageQuery) throws IOException, ParseException {
        return null;
    }

    @Override
    public void addBrandIndex(Brand Brand) throws IOException {

    }

    @Override
    public void deleteBrandIndexById(String id) throws IOException {

    }
}
