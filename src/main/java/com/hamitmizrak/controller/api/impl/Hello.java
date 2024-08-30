package com.hamitmizrak.controller.api.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    // localhost:4444/monitoring/hello
    @GetMapping("/monitoring/hello")
    public String helloMonitoring(){
        return "Merhabalar Monitoring";
    }
}
