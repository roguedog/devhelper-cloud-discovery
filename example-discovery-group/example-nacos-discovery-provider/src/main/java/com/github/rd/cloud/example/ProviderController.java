package com.github.rd.cloud.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
