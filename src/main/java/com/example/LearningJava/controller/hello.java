package com.example.LearningJava.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @Value("${player.name}")
    private String Name;
    @Value("${player.age}")
    private int Age;

    @GetMapping("v1/api/hello")
    public String status(){
        return Name + " "+ Age;
    }
}
