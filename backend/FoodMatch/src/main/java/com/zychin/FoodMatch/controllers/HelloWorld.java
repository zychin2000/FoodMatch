package com.zychin.FoodMatch.controllers;


import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    int i;

    public HelloWorld() {
        i=0;
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from  Boot! " + i++;
    }


}

