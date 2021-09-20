package com.ke.mall.service.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author ningwang
 * @version v1
 * @apidoc
 * @summary
 * @since 2020/4/22
 **/
//@Component
public class ConsumerDemo1 {
    @KafkaListener(topics = "mall-0709")
    public void listen(ConsumerRecord record){
        System.out.println(record.topic() + " " + record.offset() + " " + record.value());

    }
}
