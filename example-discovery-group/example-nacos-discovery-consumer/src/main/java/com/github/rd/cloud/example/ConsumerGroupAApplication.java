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
        //让矿建的feign中的httpClient失效， org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration
        System.setProperty("feign.httpclient.enabled", "false");
        SpringApplication.run(ConsumerGroupAApplication.class, args);
    }

}
