package com.zyy.service_feign.web;

import com.zyy.service_feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: 郑玥延
 * @Date: 15:29 2018/7/5
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/hi")
    public String hello(){
        return helloService.sayHiFromClientOne();
    }

}
