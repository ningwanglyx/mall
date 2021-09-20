package com.ke.mall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.PostConstruct;

/**
 * @Summary: 修改RedisTemplate的序列化器
 * @Author: YangxingLiu
 * @Since: 2020/1/19 16:42
 */
@Configuration
public class RedisConfig {
    @Autowired
    private RedisTemplate redisTemplate;

    @PostConstruct
    public void init(){
        initRedisTemplate();
    }

    //设置RedisTemplate的序列化器
    private void initRedisTemplate(){
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setDefaultSerializer(stringSerializer);
        redisTemplate.setKeySerializer(stringSerializer);
        //将redisTempalte的值序列化器设置为String类型
        redisTemplate.setValueSerializer(stringSerializer);
        //redisTemplate.setHashKeySerializer(stringSerializer);
    }
}
