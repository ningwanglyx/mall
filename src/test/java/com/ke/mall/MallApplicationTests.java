package com.ke.mall;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.alibaba.fastjson.JSONObject;
import com.ke.mall.model.PmsBrand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallApplicationTests {
    //@Autowired
    //private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {

    }

    @Test
    public void testBrandController(){
        /*JSONObject res = restTemplate.getForObject("/brand/listAll", JSONObject.class);
        List<PmsBrand> list  = (List<PmsBrand>) res.get("data");
        System.out.println(list.size());*/

        AerospikeClient client = new AerospikeClient("0.0.0.0", 3000);

        Key key = new Key("test", "demo", 125);

        Bin bin1 = new Bin("e1", "properties");
        Map<String, Object> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        map.put("key1", list);
        map.put("key2", "value2");
        Bin bin2 = new Bin("ei1", map);

        client.put(null, key, bin1, bin2);
        Record record = client.get(null, key);

        client.close();

        String p1 = record.getString("e1");
        System.out.println(p1);
        Map<String, Object> p2 = (Map<String, Object>) record.getMap("ei1");
        System.out.println(p2.get("key2"));


    }

}
