package devhelper.cloud.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderGroupAApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "18082");
        System.setProperty("spring.profiles.active", "group");
        SpringApplication.run(ProviderGroupAApplication.class, args);
    }

}
