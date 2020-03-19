package com.ke.mall.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/3/1 15:42
 */
@Component
@Order(value = 1)
public class BrandRunner implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
