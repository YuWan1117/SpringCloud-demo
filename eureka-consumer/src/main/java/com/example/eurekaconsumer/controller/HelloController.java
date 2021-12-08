package com.example.eurekaconsumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class HelloController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("greet")
    public String sayHello(@RequestParam String user){
        log.info("receive a greet request, user={}", user);
        return restTemplate.getForObject("http://EUREKA-PRODUCER/sayHello?user=" + user, String.class);
    }

}
