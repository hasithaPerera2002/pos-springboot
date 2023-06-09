package com.devStack.pos.pos.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/test")
public class TestController {

    @Value("${server.port}")
    int portNo;

    @Value("${spring.application.name}")
    String appName;


    @GetMapping("/process")
    public String test() {
        return appName + "started and running on port no : " + portNo;
    }
}
