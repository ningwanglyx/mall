package com.ke.mall.service;

import com.ke.mall.model.PmsBrand;

/**
 * @Summary: redis和数据库一致性
 * @Author: YangxingLiu
 * @Since: 2020/3/2 17:38
 */
public interface IRedisPmsBrandService {

    String getPmsBrand(String key);

    void setPmsBrand(PmsBrand pmsBrand);
}
