package com.ke.mall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/2/1 17:34
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
