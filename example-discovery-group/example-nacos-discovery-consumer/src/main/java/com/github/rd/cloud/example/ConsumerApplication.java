package com.github.rd.cloud.example;

@SpringBootApplication
@EnableDiscoveryClient(autoRegister = true)
@EnableFeignClients
public class ConsumerApplication {

    @LoadBalanced
    @Bean
    @SentinelRestTemplate(urlCleanerClass = UrlCleaner.class, urlCleaner = "clean")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @LoadBalanced
    @Bean
    @SentinelRestTemplate
    public RestTemplate restTemplate1() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @FeignClient(name = "service-provider", fallback = EchoServiceFallback.class,
            configuration = FeignConfiguration.class)
    public interface EchoService {

        @GetMapping("/echo/{str}")
        String echo(@PathVariable("str") String str);

        @GetMapping("/divide")
        String divide(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

        default String divide(Integer a) {
            return divide(a, 0);
        }

        @GetMapping("/notFound")
        String notFound();

    }

}

class FeignConfiguration {

    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }

}

class EchoServiceFallback implements EchoService {

    @Override
    public String echo(@PathVariable("str") String str) {
        return "echo fallback";
    }

    @Override
    public String divide(@RequestParam Integer a, @RequestParam Integer b) {
        return "divide fallback";
    }

    @Override
    public String notFound() {
        return "notFound fallback";
    }

}
