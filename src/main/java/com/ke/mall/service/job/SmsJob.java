package com.ke.mall.service.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/3/2 15:05
 */
@Component
@Slf4j
public class SmsJob {

    @Scheduled(cron = "0 */30 * * * ?")
    public void test(){
        System.out.println("你好———————————————   ———————————————");
    }
}
