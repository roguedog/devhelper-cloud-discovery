package io.github.roguedog.devhelper.cloud;

import io.github.roguedog.devhelper.cloud.discovery.DevHelperFeignClientAutoConfiguration;
import io.github.roguedog.devhelper.cloud.registry.DevHelperRegistryServiceIdOverwriteAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * devhelper的Nacos服务注册发现配置
 * @author zhangkai
 */
@Configuration
@Import({DevHelperFeignClientAutoConfiguration.class, DevHelperRegistryServiceIdOverwriteAutoConfiguration.class})
public class DevHelperNocosDiscoveryAutoConfiguration {
    public DevHelperNocosDiscoveryAutoConfiguration() {
    }
}
