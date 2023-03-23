package com.example.redistest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
public class OrderService {

    public static final String ORDER_KEY = "ord:";
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void addOrder(){
        int keyId = ThreadLocalRandom.current().nextInt(1000) + 1;
        String serialNo = UUID.randomUUID().toString();

        String key = ORDER_KEY+keyId;
        String value = "京东订单"+serialNo;
        stringRedisTemplate.opsForValue().set(key,value);

        //String key = "中文";
        //String value ="汉字";
        //stringRedisTemplate.opsForValue().set(key,value);

        log.info("***key:{}",key);
        log.info("***value:{}",value);
    }

    public String getOrderById(Integer keyId){
        return stringRedisTemplate.opsForValue().get(ORDER_KEY+keyId);
        //return  stringRedisTemplate.opsForValue().get("k"+keyId);
        //return  stringRedisTemplate.opsForValue().get("中文");
    }
}
