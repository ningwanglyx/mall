package com.ke.mall.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ningwang
 * @version v1
 * @apidoc
 * @summary
 * @since 2020/8/23
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test1")
    String test(){
        System.out.println("hello");
        return "hello java";
    }


}
