package devhelper.cloud.example;

import devhelper.cloud.DevHelperCloudDiscoveryConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderGroupAApplication {

    public static void main(String[] args) {
        String prefixGroup = DevHelperCloudDiscoveryConstant.PREFIX_GROUP;
        System.setProperty("server.port", "18082");
        System.setProperty("spring.profiles.active", "group");
        SpringApplication.run(ProviderGroupAApplication.class, args);
    }

}
