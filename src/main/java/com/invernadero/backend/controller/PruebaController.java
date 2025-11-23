package com.invernadero.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {

    @GetMapping("/api/ping")
    public String ping() {
        return "Backend Invernadero OK";
    }
}
