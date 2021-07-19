package com.github.rd.cloud.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProviderGroupAApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "18082");
        System.setProperty("xxx.cloud.discovery.group.enabled", "true");
        SpringApplication.run(ProviderGroupAApplication.class, args);
    }

}
