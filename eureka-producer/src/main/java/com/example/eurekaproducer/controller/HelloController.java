package com.example.eurekaproducer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @RequestMapping("sayHello")
    public String sayHello(@RequestParam String user) {
        log.info("receive a sayHello request, user={}", user);
        return "Hello " + user;
    }

    @RequestMapping("hello")
    public String hello() {
        log.info("receive a hello request");
        return "Hello World.";
    }
}
