package com.bank_lab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RestController
public class HelloController {
    @GetMapping("/api/v1/hello")
    public Map<String, String> hello(){
        return Map.of(
                "message", "Welcome to APP Banlk",
                "status", "success"
        );
    }

    @GetMapping("/api/v1/about")
    public Map<String, String> about(){
        return Map.of(
                "application", "App bank lab",
                "version", "1.0.0",
                "framework", "Spring Boot"
        );
    }

    @GetMapping("/api/v1/greet")
    public Map<String, String> greet(@RequestParam(defaultValue = "Guest") String name){

        return Map.of(
                "message", "Hello, " + name,
                "status", "success"
        );
    }

}
