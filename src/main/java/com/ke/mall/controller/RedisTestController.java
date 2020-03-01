package com.ke.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Summary: 学习redis操作用的类
 * @Author: YangxingLiu
 * @Since: 2020/2/19 14:47
 */
@RestController
@RequestMapping("/redis")
public class RedisTestController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 测试reidis字符串类型基本操作，opsForValue
     * @return
     */
    @GetMapping("/test1")
    public String testRedis(){
        redisTemplate.opsForValue();
        redisTemplate.opsForList();
        redisTemplate.opsForSet();
        redisTemplate.opsForZSet();
        redisTemplate.opsForHash();

        redisTemplate.opsForValue().set("key1", "value1");
        String value1 = (String) redisTemplate.opsForValue().get("key1");
        System.out.println("value1: " + value1);

        redisTemplate.opsForValue().set("key2", "value2");
        redisTemplate.delete("key1");
        String oldVlues2 = (String) redisTemplate.opsForValue().getAndSet("key2", "new_value2");
        System.out.println("oldValue2: " + oldVlues2);

        String newValue2 = (String) redisTemplate.opsForValue().get("key2");
        System.out.println("newValue2: " + newValue2);
        String rangeValue2 = (String)redisTemplate.opsForValue().get("key2", 0, 2);
        System.out.println("rangeValue2: " + rangeValue2);
        int newLen = redisTemplate.opsForValue().append("key2", "_app");
        System.out.println("newLen: " + newLen);
        String appendValue2 = (String) redisTemplate.opsForValue().get("key2");
        System.out.println("appendValue2: " + appendValue2);
        String nothing = (String) redisTemplate.opsForValue().get("key1");
        System.out.println("nothing: " + nothing);

        return "ok";
    }

    @GetMapping("/test2")
    public String test2(){
        redisTemplate.opsForValue().set("num", "22");
        System.out.println("num: " + redisTemplate.opsForValue().get("num"));

        redisTemplate.opsForValue().increment("num", 2);
        System.out.println("num: " + redisTemplate.opsForValue().get("num"));

        redisTemplate.opsForValue().decrement("num");
        redisTemplate.opsForValue().decrement("num");
        System.out.println("num: " + redisTemplate.opsForValue().get("num"));
        return "test2";
    }

    /**
     * 测试opsForHash的操作
     * @return
     */
    @GetMapping("/test3")
    public String test3(){
        String key = "asr:1002:today";
        Map<String, String> map = new HashMap<>();
        map.put("1", "seqxxx1");
        map.put("2", "seqxxx2");
        redisTemplate.opsForHash().putAll(key, map);
        redisTemplate.opsForHash().put(key, "3", "seqxxx3");
        String s1 = (String) redisTemplate.opsForHash().get(key, "2");
        System.out.println("s1: " + s1);
        boolean exists = redisTemplate.opsForHash().hasKey(key, "4");
        System.out.println("exists: " + exists);

        Map keyValMap = redisTemplate.opsForHash().entries(key);
        for (Object o : keyValMap.keySet()) {
            System.out.println(o);
        }
        for (Object o : keyValMap.values()){
            System.out.println(o);
        }
        return "test3";
    }
}
