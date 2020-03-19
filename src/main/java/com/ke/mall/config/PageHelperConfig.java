package com.ke.mall.config;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/3/1 15:46
 */
@Configuration
public class PageHelperConfig {

    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        // 数据库
        properties.setProperty("helperDialect", "mysql");
        // 是否将参数offset作为PageNum使用
        properties.setProperty("offsetAsPageNum", "true");
        // 是否进行count查询
        properties.setProperty("rowBoundsWithCount", "true");
        // 是否分页合理化
        properties.setProperty("reasonable", "false");
        pageHelper.setProperties(properties);
        return pageHelper;

    }

}
