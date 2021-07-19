package com.github.rd.cloud.example.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.clientconfig.OkHttpFeignConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ConditionalOnClass({OkHttpClient.class})
@ConditionalOnProperty({"feign.okhttp.enabled"})
@Import({OkHttpFeignConfiguration.class})
public class LoadBalancerFeignClientConfig {
}
