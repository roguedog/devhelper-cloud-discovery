package devhelper.cloud.example;

import devhelper.cloud.DevHelperCloudDiscoveryConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerGroupAApplication {

    public static void main(String[] args) {
        String prefixGroup = DevHelperCloudDiscoveryConstant.PREFIX_GROUP;
        System.setProperty("server.port", "18083");
        System.setProperty("spring.profiles.active", "group");
        SpringApplication.run(ConsumerGroupAApplication.class, args);

    }

}
