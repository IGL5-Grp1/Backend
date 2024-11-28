package com.project.gestion_examens.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "Access Token Authorization")
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/1")
    public String test1() {
        return "Hello World";
    }

    @GetMapping("/2")
    public String test2() {
        throw new RuntimeException("This is working as expected, it's a test exception");
//        return "Hello World 2";
    }
}
