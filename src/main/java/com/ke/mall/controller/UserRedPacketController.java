package com.ke.mall.controller;


import com.ke.mall.service.impl.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;

/**
 * @Summary: 并发抢红包
 * @Author: YangxingLiu
 * @Since: 2020/2/1 17:25
 */
@RestController
@RequestMapping("/redPacket")
public class UserRedPacketController {
    @Autowired
    private UserRedPacketService userRedPacketService;
    /**
     *
     */
    @Autowired
    private Executor executor;
    @GetMapping("/grap")
    public String grapRedPacket(){
        Integer redPacketId = 6;
        for(int i = 1; i <= 25000; i++){
            Integer userId = i;
            Runnable r = () -> {
                userRedPacketService.grapRedPacketForVersion(redPacketId, userId);
            };
            executor.execute(r);
        }
        return "finish";
    }

}
