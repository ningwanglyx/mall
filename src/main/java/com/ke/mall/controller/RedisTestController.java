package com.ke.mall.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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
        /*redisTemplate.opsForValue().set("key1", "value1");
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
        System.out.println("nothing: " + nothing);*/
        redisTemplate.opsForValue().set("increLong", 2L);
        redisTemplate.opsForValue().increment("increLong", 20L);
        redisTemplate.delete("heheh");
        System.out.println("==========" + redisTemplate.opsForValue().get("increLong").toString());

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

    /**
     * 测试opsForList
     * @return
     */
    @GetMapping("/test4")
    public String test4(){
        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        //List<String> list = new ArrayList<>();
        listOperations.leftPush("firstList", "bob");
        //list.add("bob");
        //list.add("ted");
        listOperations.leftPush("firstList", "jack");
        listOperations.leftPush("firstList", "li");
        System.out.println(listOperations.size("firstList"));
        System.out.println(listOperations.index("firstList", 0));
        System.out.println(listOperations.index("firstList", 1));
        System.out.println(listOperations.index("firstList", 2));
        StringUtils.equals(null, null);
        return "test4";
    }

    @GetMapping("/test5")
    public void test5(){
        ListOperations listOperations = redisTemplate.opsForList();
        /*System.out.println("1001有序集合的初始长度为：" + listOperations.size("1001"));
        listOperations.leftPush("1001", "1");
        Integer i = 2;
        listOperations.leftPush("1001", i.toString());
        System.out.println(listOperations.size("1001"));
        System.out.println(listOperations.index("1001", 0));
        int o1 = (int) listOperations.index("1001", 1);*/

        //listOperations.leftPush("key", "people");
        //listOperations.leftPush("key", "animal");
        System.out.println(listOperations.size("key"));
        //System.out.println(listOperations.index("key", 0));
        //System.out.println(listOperations.index("key", 1));
        //System.out.println(listOperations.index("key", 2));
        List<String> res = listOperations.range("key",0, listOperations.size("key")-1);
        for (String re : res) {
            System.out.println(re);
        }
    }

    @GetMapping("/test6")
    public void test6(){
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("one", "bob");
        setOperations.add("one", "tom");
        setOperations.add("two", "ami");
        //添加元素
        setOperations.add("two", "bob");
        //获取set中的全部元素
        Set<String> set = setOperations.members("one");
        //交集
        Set<String> set2 = setOperations.difference("one", "two");
        //并集
        setOperations.union("one", "two");
        //是否包含
        setOperations.isMember("one", "tom");
    }
}
