package devhelper.cloud.eureka.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 本地开发时，在src/test目录下配置和启动项目，不污染源代码
 * @author zhangkai
 */
@SpringBootApplication
public class EurekaConsumerDevApplication {
    public static void main(String[] args) {
        //引入分组的配置文件
        System.setProperty("spring.profiles.active", "group");
        SpringApplication.run(EurekaConsumerDevApplication.class, args);

    }
}
