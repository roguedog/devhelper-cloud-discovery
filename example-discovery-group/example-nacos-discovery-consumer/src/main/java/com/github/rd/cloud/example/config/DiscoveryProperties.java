package com.github.rd.cloud.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "xxx.cloud.discovery.dev-helper")
public class DiscoveryProperties {

    private final Map<String,String> group =new HashMap<>();
    private final Map<String,String> replaceName =new HashMap<>();

    public Map<String, String> getGroup() {
        return group;
    }

    public Map<String, String> getReplaceName() {
        return replaceName;
    }
}
