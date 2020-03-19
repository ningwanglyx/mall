package com.ke.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ke.mall.model.PmsBrand;
import com.ke.mall.service.IPmsBrandService;
import com.ke.mall.service.mapper.PmsBrandMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/1/18 19:14
 */

@Slf4j
@Service
public class PmsBrandService implements IPmsBrandService {
    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return pmsBrandMapper.findAll();
    }

    @Override
    @Transactional
    public int createBrand(PmsBrand brand) {
        return pmsBrandMapper.insert(brand);
    }

    @Override
    @Transactional
    public void updateBrand(PmsBrand brand) {
        pmsBrandMapper.updateByPrimaryKey(brand);

    }

    @Override
    @Transactional
    public void deleteBrand(Long id) {
        pmsBrandMapper.deleteByPrimaryKey(id);

    }

    @Override
    public PmsBrand findById(Long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public PmsBrand findByLogo(String logo) {
        return pmsBrandMapper.fondByLogo(logo);
    }

    @Override
    public PageInfo<PmsBrand> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PmsBrand> list = pmsBrandMapper.findAll();
        PageInfo<PmsBrand> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
