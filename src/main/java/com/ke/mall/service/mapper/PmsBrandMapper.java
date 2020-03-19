package com.ke.mall.service.mapper;

import com.ke.mall.model.PmsBrand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @version v1
 * @author liuyangxing
 * @since 2020/1/18
 * @summary pmsBrand mapper接口
 **/
@Component
public interface PmsBrandMapper {

    List<PmsBrand> findAll();

    int insert(@Param("pmsBrand") PmsBrand pmsBrand);

    int updateByPrimaryKey(@Param("pmsBrand") PmsBrand pmsBrand);

    int deleteByPrimaryKey(@Param("id") Long id);

    PmsBrand selectByPrimaryKey(@Param("id") Long id);

    int updateByPrimaryKeySelective(PmsBrand record);

    PmsBrand fondByLogo(@Param(value = "logo") String logo);

    //List<PmsBrand> findList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);


}