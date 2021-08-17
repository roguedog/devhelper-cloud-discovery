package io.github.roguedog.devhelper.cloud.example;

import org.springframework.boot.SpringApplication;

/**
 * 本地开发时，在src/test目录下配置和启动项目，不污染源代码
 * @author zhangkai
 */
public class NacosConsumerDevApplication {
    public static void main(String[] args) {
        //引入devhelper的配置文件
        System.setProperty("spring.profiles.active", "dev");
        //用src/main/java包下的启动类启动应用，避免重复的配置
        SpringApplication.run(NacosConsumerApplication.class, args);
    }
}
