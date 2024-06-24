package com.example.anderson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping
    public String get() {
    return "ASJDKAJDKAJI";
    }
}
