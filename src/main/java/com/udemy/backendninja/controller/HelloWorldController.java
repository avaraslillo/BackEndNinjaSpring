package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/soy")

public class HelloWorldController {
    @GetMapping("/helloworld")
    
    public String helloWorld(){
        return "helloworld";
    }
}
