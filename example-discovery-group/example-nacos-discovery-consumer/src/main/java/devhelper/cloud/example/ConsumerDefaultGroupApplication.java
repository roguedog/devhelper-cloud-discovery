package devhelper.cloud.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerDefaultGroupApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "18083");
        SpringApplication.run(ConsumerDefaultGroupApplication.class, args);
    }

}
