package com.zyy.service_ribbon.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.zyy.service_ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: 郑玥延
 * @Date: 14:58 2018/7/5
 */
@Service
public class HelloServiceImpl implements HelloService{

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService() {
        return restTemplate.getForObject("http://SERVICE-HI/hi",String.class);
    }

    public String hiError(){
        return "sorry error";
    }

}
