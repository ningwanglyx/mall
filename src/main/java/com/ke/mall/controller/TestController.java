package com.ke.mall.controller;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.policy.WritePolicy;
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
        AerospikeClient client = new AerospikeClient("192.168.151.171", 3000);
        WritePolicy policy = new WritePolicy();
        policy.timeoutDelay = 50;
        Key key = new Key("test_namespace","test_setname","test_key");
        Bin binString = new Bin("name","value");
        client.put(policy,key,binString);

        System.out.println("hello");
        return "hello java";
    }


}
