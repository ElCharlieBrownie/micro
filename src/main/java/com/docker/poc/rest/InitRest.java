package com.docker.poc.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitRest {
    @GetMapping("/")
    public String hello() {
        return "¡Hola, Jenkins + Docker!";
    }

}
