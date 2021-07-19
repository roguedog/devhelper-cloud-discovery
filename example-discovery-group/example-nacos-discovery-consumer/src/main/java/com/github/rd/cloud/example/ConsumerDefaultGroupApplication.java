package com.github.rd.cloud.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient(autoRegister = true)
@EnableFeignClients
public class ConsumerDefaultGroupApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "18083");
        SpringApplication.run(ConsumerDefaultGroupApplication.class, args);
    }

}
