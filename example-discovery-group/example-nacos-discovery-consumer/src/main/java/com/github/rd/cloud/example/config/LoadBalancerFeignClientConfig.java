package com.github.rd.cloud.example.config;

import feign.Client;
import feign.okhttp.OkHttpClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.clientconfig.OkHttpFeignConfiguration;
import org.springframework.cloud.openfeign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * feign远程调用重写配置
 */
@Configuration(
        proxyBeanMethods = false
)
@ConditionalOnClass({OkHttpClient.class})
@ConditionalOnProperty(value = {"xxx.cloud.dev-helper.discovery.group.enabled"}, matchIfMissing = false)
@EnableConfigurationProperties({DiscoveryProperties.class})
@Import({OkHttpFeignConfiguration.class})
public class LoadBalancerFeignClientConfig {

    LoadBalancerFeignClientConfig() {
    }

    @Bean
    @ConditionalOnMissingBean({Client.class})
    public Client feignClient(CachingSpringLoadBalancerFactory cachingFactory, SpringClientFactory clientFactory, okhttp3.OkHttpClient okHttpClient, DiscoveryProperties discoveryProperties) {
        OkHttpClient delegate = new OkHttpClient(okHttpClient);
        return new MyLoadBalancerFeignClient(delegate, cachingFactory, clientFactory, discoveryProperties);
    }

}
