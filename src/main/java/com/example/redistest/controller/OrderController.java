package com.example.redistest.controller;

import com.example.redistest.service.OrderService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@Api(tags = "订单接口")
public class OrderController {
    @Resource
    private OrderService orderService;


    @RequestMapping(value = "/order/add",method = RequestMethod.POST)
    public void addOrder(){
        orderService.addOrder();
    }

    //@RequestMapping(value = "/order/{keyId}}",method = RequestMethod.GET)
    @GetMapping(value = "/order/{keyId}")
    public void getOrder(@PathVariable("keyId")Integer keyId){
        System.out.println(orderService.getOrderById(keyId));

    }

    @RequestMapping(value = "/v/{keyId}}",method = RequestMethod.POST)
    //@GetMapping(value = "/v/{keyId}")
    public void getV(@PathVariable("keyId")Integer keyId){
        System.out.println(keyId);
    }



    @GetMapping(value = "/hello")
    public String gg(){
        return "hello";
    }
    @GetMapping(value = "/b")
    public String ggb(){
        System.out.println("hh");
        System.out.println("hhgit");
        return "hello";
    }

}
