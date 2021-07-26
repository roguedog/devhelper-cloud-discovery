package devhelper.cloud.nacos;

import devhelper.cloud.nacos.discovery.DevHelperFeignClientAutoConfiguration;
import devhelper.cloud.nacos.registry.DevHelperRegistryServiceIdOverwriteAutoConfiguration;
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
