package com.fw.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloworldController {
    @GetMapping("/")
    public String helloworld() {
        return "hello world";
    }
}