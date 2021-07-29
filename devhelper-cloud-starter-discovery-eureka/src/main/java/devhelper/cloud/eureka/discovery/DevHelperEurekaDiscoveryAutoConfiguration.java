package devhelper.cloud.eureka.discovery;

import devhelper.cloud.eureka.discovery.registry.DevHelperRegistryServiceIdOverwriteAutoConfiguration;
import devhelper.cloud.nacos.discovery.DevHelperFeignClientAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * devhelper的Eureka服务注册发现配置
 * @author yuzicheng
 */
@Configuration
@Import({DevHelperFeignClientAutoConfiguration.class, DevHelperRegistryServiceIdOverwriteAutoConfiguration.class})
public class DevHelperEurekaDiscoveryAutoConfiguration {

}
