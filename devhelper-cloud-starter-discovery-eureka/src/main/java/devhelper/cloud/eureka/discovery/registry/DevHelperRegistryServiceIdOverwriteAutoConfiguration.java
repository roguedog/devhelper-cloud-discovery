package devhelper.cloud.eureka.discovery.registry;

import devhelper.cloud.nacos.registry.DevHelperRegistryProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 服务注册时增加分组后缀
 *
 * @author yuzicheng
 */
@Configuration
@ConditionalOnProperty(value = {"devhelper.cloud.registry.enabled"}, matchIfMissing = false)
@ConditionalOnClass({EurekaClientAutoConfiguration.class})
@EnableConfigurationProperties(DevHelperRegistryProperties.class)
public class DevHelperRegistryServiceIdOverwriteAutoConfiguration {

    @Bean
    public EurekaConfigBeanPostProcessor getEurekaConfigBeanPostProcessor(DevHelperRegistryProperties registryProperties) {
        return new EurekaConfigBeanPostProcessor(registryProperties);

    }
}
