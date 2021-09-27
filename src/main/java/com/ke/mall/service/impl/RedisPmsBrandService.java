package com.ke.mall.service.impl;

import com.ke.mall.model.PmsBrand;
import com.ke.mall.service.IPmsBrandService;
import com.ke.mall.service.IRedisPmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;


/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/3/2 17:40
 */
@Service
public class RedisPmsBrandService implements IRedisPmsBrandService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IPmsBrandService pmsBrandService;

    /**
     * 首先从redis中获取品牌信息，如果没有，则从数据库中获取品牌信息，同时将品牌信息存放到redis中
     * @param key
     * @return
     */
    @Override
    public String getPmsBrand(String key) {
        ValueOperations<String, String> string = redisTemplate.opsForValue();
        //判断redis中是否存在key
        if(redisTemplate.hasKey(key)){
            return string.get(key);
        }
        String value = pmsBrandService.findByLogo(key).getName();
        string.set(key, value);
        return value;
    }

    @Override
    public void setPmsBrand(PmsBrand pmsBrand) {

    }
}
