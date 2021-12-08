package com.example.eurekaproducer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("sayHello")
    public String sayHello(String user) {
        log.info("receive a sayHello request, user={}", user);
        return "Hello " + user;
    }
}
