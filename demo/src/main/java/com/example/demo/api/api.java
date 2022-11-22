package com.example.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/test")
@RestController
public class api {
    
    @GetMapping
    public String hello(){
        return "hello bitch";
    }

    @PostMapping
    public String hi(){
        return "hello bitch";
    }

}
