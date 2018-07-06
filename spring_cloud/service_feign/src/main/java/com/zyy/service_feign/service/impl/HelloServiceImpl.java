package com.zyy.service_feign.service.impl;

import com.zyy.service_feign.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 郑玥延
 * @Date: 10:08 2018/7/6
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHiFromClientOne() {
        return "sorry error feign";
    }
}
