package com.fw.template.board.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@Api(value="HelloController Swagger", tags = "HelloController")
@RestController
public class HelloworldController {
    @GetMapping("/")
    @ApiOperation(value = "helloworld")
    public String helloworld() {
        return "hello world";
    }
}