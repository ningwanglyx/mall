package com.ke.mall;

import com.alibaba.fastjson.JSONObject;
import com.ke.mall.model.PmsBrand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {

    }

    @Test
    public void testBrandController(){
        JSONObject res = restTemplate.getForObject("/brand/listAll", JSONObject.class);
        List<PmsBrand> list  = (List<PmsBrand>) res.get("data");
        System.out.println(list.size());

    }

}
