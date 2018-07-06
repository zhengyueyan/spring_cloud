package com.zyy.service_feign.service;

import com.zyy.service_feign.service.impl.HelloServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description:
 * @Author: 郑玥延
 * @Date: 15:27 2018/7/5
 */
@FeignClient(value = "service-hi",fallback = HelloServiceImpl.class)
public interface HelloService {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne();

}
