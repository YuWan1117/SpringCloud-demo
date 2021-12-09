package com.example.eurekaconsumer.controller;

import com.example.eurekaconsumer.impl.EurekaFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @Autowired
    private EurekaFeignService eurekaFeignService;

    @RequestMapping("greet")
    public String greet(){
        log.info("receive a greet request");
        return eurekaFeignService.hello();
    }

    @RequestMapping(value = "sayGreet")
    public String sayGreet(@RequestParam String user){
        log.info("receive a sayGreet request, user={}", user);
        return eurekaFeignService.sayHello(user);
    }

}
