package devhelper.cloud.nacos.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 本地开发时，在src/test目录下配置和启动项目，不污染源代码
 * @author zhangkai
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "18081");
        SpringApplication.run(NacosProviderApplication.class, args);
    }

}
