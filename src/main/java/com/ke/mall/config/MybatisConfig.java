package com.ke.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Summary: 配置需要动态生成mapper接口的路径
 * @Author: YangxingLiu
 * @Since: 2020/1/18 15:56
 */
@Configuration
@MapperScan("com.ke.mall.service.mapper")
public class MybatisConfig {
}
