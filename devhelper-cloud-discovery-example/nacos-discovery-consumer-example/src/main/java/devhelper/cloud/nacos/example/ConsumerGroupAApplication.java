package devhelper.cloud.nacos.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerGroupAApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "18083");
        System.setProperty("spring.profiles.active", "group");
        SpringApplication.run(ConsumerGroupAApplication.class, args);

    }

}
