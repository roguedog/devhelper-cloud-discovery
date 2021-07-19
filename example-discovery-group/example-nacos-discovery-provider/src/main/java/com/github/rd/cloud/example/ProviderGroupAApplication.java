package com.github.rd.cloud.example;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.registry.NacosServiceRegistryAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@EnableDiscoveryClient
@SpringBootApplication
public class ProviderGroupAApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "18082");
        System.setProperty("codemao.cloud.discovery.group.enabled", "true");
        SpringApplication.run(ProviderGroupAApplication.class, args);
    }

}
