package com.ke.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ningwang
 * @version v1
 * @apidoc
 * @summary
 * @since 2020/4/21
 **/
@RestController
@RequestMapping(value = "/kafka")
public class KafkaConsumerController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/test")
    public String sendMessage(@RequestParam(value = "message") String message){
        kafkaTemplate.send("mall-topic", message);
        return "OK";
    }
}
