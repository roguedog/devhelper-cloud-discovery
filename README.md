# Spring cloud、Alibaba cloud开发助手

## 介绍

#### 微服务本地开发时，如果本地服务注册到其他环境，会污染其他环境、影响其他人使用。devhelper-cloud-discovery可以解决这个问题(注：不要在生产环境使用)
 
## 添加依赖
- 版本说明
  - 1.0-SNAPSHOT 实验
  - release待发布
  
如果注册中心用的是nacos（spring-cloud-starter-alibaba-nacos-discovery），添加以下依赖：
```xml
<dependency>
    <groupId>devhelper-cloud</groupId>
    <artifactId>devhelper-cloud-starter-discovery-nacos</artifactId>
    <version>x.y.z</version>
    <!--只能在开发阶段使用，必须配置为test，最好用dependencyManagement来管理-->
    <scope>test</scope>
</dependency>
<!--如果注册中心用的是eureka，敬请期待：-->

```
如果注册中心用的是eureka，敬请期待!
```xml
<dependency>
  <groupId>devhelper-cloud</groupId>
  <artifactId>devhelper-cloud-starter-discovery-eureka</artifactId>
  <version>x.y.z</version>
  <!--只能在开发阶段使用，必须配置为test，最好用dependencyManagement来管理-->
  <scope>test</scope>
</dependency>
```

## 配置(在src/test目录里配置，不污染源代码)
- 在src/test/resources目录下的application-dev.yaml中配置
```yaml
devhelper:
  cloud:
    # 服务注册配置
    registry:
      #开启devhelper的服务注册
      enabled: true
      #对服务注册进行分组，分组名配置为group-1，默认值本机hostname
      group: group-1
    # 服务发现配置
    discovery:
      #开启devhelper的服务发现
      enabled: true
      # 发现指定分组下的服务，JSON格式，key：服务名称，value: 分组名称
      group: { "service-provider": "group-1" }
```
- 如果想使用src/main/resources目录下的配置文件，可以配置：
```xml
<build>
  <testResources>
    <testResource>
      <!--使用src/main/resources目录下的配置-->
      <directory>src/main/resources</directory>
    </testResource>
    <testResource>
      <directory>src/test/resources</directory>
    </testResource>
  </testResources>
</build>
```
- 在src/test/java目录下配置启动类
```java
/**
 * 本地开发时，在src/test目录下配置和启动项目，不污染源代码
 * @author zhangkai
 */
public class NacosConsumerDevApplication {
  public static void main(String[] args) {
    //引入分组的配置文件
    System.setProperty("spring.profiles.active", "dev");
    //用src/main/java包下的启动类(NacosConsumerApplication)启动应用，避免重复的配置
    SpringApplication.run(NacosConsumerApplication.class, args);
  }
}
```

### 配置详解

| 配置项 | 描述 | 类型 | 默认值 |
|------|------------|------|-------|
| devhelper.cloud.registry.enabled | devhelper的服务注册是否开启 | boolean | false (默认不开启，也是为了避免生产环境使用) |
| devhelper.cloud.registry.group | 对服务注册进行分组，注册的服务名称变成[provider-name].[group-name] | String | 本机的hostname (hostname有利于开发人员识别服务注册方) |
| devhelper.cloud.discovery.enabled | devhelper的服务发现是否开启 | boolean | false (默认不开启，也是为了避免生产环境使用) |
| devhelper.cloud.discovery.group | 发现指定分组下的服务 | JSON对象{"服务名称-1": "分组名称", "服务名称": "分组名称"} | 空 |

## 可以参考example代码

- Nacos
    - [nacos-discovery-consumer-example](./devhelper-cloud-discovery-example/nacos-discovery-consumer-example)
    - [nacos-discovery-provider-example](./devhelper-cloud-discovery-example/nacos-discovery-consumer-example)

- Eureka
    - [eureka-discovery-consumer-example](./devhelper-cloud-discovery-example/eureka-discovery-consumer-example)
    - [eureka-discovery-provider-example](./devhelper-cloud-discovery-example/eureka-discovery-consumer-example)

