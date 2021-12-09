package com.example.eurekaconsumer.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "eureka-producer")
public interface EurekaFeignService {

    @RequestMapping(value = "sayHello", headers = {"Content-Type=application/json"})
    String sayHello(@RequestParam String user);

    @RequestMapping(value = "hello")
    String hello();
}
