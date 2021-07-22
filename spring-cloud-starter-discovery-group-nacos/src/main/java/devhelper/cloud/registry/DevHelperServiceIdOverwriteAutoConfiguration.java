package devhelper.cloud.registry;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.registry.NacosServiceRegistryAutoConfiguration;
import devhelper.cloud.DevHelperCloudDiscoveryConstant;
import devhelper.cloud.DevHelperCloudRegistryProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

/**
 * 服务注册时增加分组后缀
 */
@Configuration
@ConditionalOnProperty(value = {"dev-helper.cloud.registry.group.enabled"}, matchIfMissing = false)
@EnableConfigurationProperties(DevHelperCloudRegistryProperties.class)
@AutoConfigureBefore(NacosServiceRegistryAutoConfiguration.class)
@AutoConfigureAfter(NacosDiscoveryProperties.class)
public class DevHelperServiceIdOverwriteAutoConfiguration {
    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;
    @Autowired
    private DevHelperCloudRegistryProperties registryProperties;

    @PostConstruct
    public void rewriteServiceId() {
        if (!StringUtils.isEmpty(registryProperties.getGroup())) {
            nacosDiscoveryProperties.setService(DevHelperCloudDiscoveryConstant.buildServiceIdByGroup(nacosDiscoveryProperties.getService(), registryProperties.getGroup()));
        }
    }
}
