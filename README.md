服务注册发现分组

本地开发时，环境隔离、联调的方案设计

1、本地服务注册时，通过org.springframework.context.ApplicationContextInitializer修改服务注册名称，[spring.application.name]-[IP]，达到隔离环境的目的
- nacos
    - 服务注册的配置入口是NacosServiceRegistryAutoConfiguration, com.alibaba.cloud.nacos.registry.NacosServiceRegistry.register
    - 服务注册名称获取方法是com.alibaba.cloud.nacos.registry.NacosRegistration.getServiceId, com.alibaba.cloud.nacos.NacosDiscoveryProperties.service，具体是通过获取配置文件@Value("${spring.cloud.nacos.discovery.service:${spring.application.name:}}")
2、自定义服务发现：

重写feign的URL https://www.cnblogs.com/zhangjianbin/p/9245023.html

在feign中mock服务 https://www.cnblogs.com/zhangjianbin/p/9245023.html，重写LoadBalancerFeignClient.execute


- 配置文件配置：codemao-dev-helper.discovery.service-rewrite.[producer-name]=[producer-name]-[IP]
- 重写服务发现：根据codemao-dev-helper.discovery.service-rewrite配置来发现需要联调的服务
- 如果用的是eureka，需要重写org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient#getInstances，
- 如果用的nacos，需要重写com.alibaba.cloud.nacos.discovery.NacosDiscoveryClien
