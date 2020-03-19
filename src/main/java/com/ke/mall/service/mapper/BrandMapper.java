package com.ke.mall.service.mapper;


import com.ke.mall.model.Brand;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKeyWithBLOBs(Brand record);

    int updateByPrimaryKey(Brand record);

    List<Brand> findAll();


}