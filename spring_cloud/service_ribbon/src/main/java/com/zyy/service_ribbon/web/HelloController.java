package com.zyy.service_ribbon.web;

import com.zyy.service_ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: 郑玥延
 * @Date: 14:59 2018/7/5
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hi")
    public String hi(){
        return helloService.hiService();
    }

}
