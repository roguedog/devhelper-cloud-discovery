package com.github.rd.cloud.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MvcConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @FeignClient(name = "service-provider")
    public interface EchoService {

        @GetMapping("/test")
        String test();
    }

    @RestController
    public static class ConsumerController {

        @Autowired
        private RestTemplate restTemplate;

        @Autowired
        private EchoService echoService;

        @Autowired
        private DiscoveryClient discoveryClient;

        /**
         * 测试：通过feign调用
         * @return
         */
        @GetMapping("/feign")
        public String rest() {
            return echoService.test();
        }

        /**
         * 测试：通过restTemplate调用
         * @return
         */
        @GetMapping("/restTemplate")
        public String index() {
            return restTemplate.getForObject("http://service-provider/test", String.class);
        }

    }
}
