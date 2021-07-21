package com.github.rd.cloud.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerGroupAApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "18083");
        //让框架的feign中的httpClient失效， org.springframework.cloud.openfeign.ribbon.HttpClientFeignLoadBalancedConfiguration
        System.setProperty("feign.httpclient.enabled", "false");
        System.setProperty("feign.okhttp.enabled", "false");
        System.setProperty("xxx.cloud.dev-helper.discovery.group.enabled", "true");
        SpringApplication.run(ConsumerGroupAApplication.class, args);
    }

}
