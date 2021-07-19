package com.github.rd.cloud.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient(autoRegister = true)
@EnableFeignClients
public class ConsumerGroupAApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "18083");
        //让框架的feign中的httpClient失效， org.springframework.cloud.openfeign.ribbon.HttpClientFeignLoadBalancedConfiguration
        System.setProperty("feign.httpclient.enabled", "false");
        System.setProperty("feign.okhttp.enabled", "false");
        SpringApplication.run(ConsumerGroupAApplication.class, args);
    }

}
