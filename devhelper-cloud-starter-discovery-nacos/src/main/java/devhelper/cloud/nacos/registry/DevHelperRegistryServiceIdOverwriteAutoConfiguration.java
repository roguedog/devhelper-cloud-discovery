package devhelper.cloud.nacos.registry;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.registry.NacosServiceRegistryAutoConfiguration;
import devhelper.cloud.nacos.DevHelperDiscoveryServiceIdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * 服务注册时增加分组后缀
 * @author zhangkai
 */
@Configuration
@ConditionalOnProperty(value = {"devhelper.cloud.registry.enabled"}, matchIfMissing = false)
@EnableConfigurationProperties(DevHelperRegistryProperties.class)
@AutoConfigureBefore(NacosServiceRegistryAutoConfiguration.class)
@AutoConfigureAfter(NacosDiscoveryProperties.class)
public class DevHelperRegistryServiceIdOverwriteAutoConfiguration {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;
    @Autowired
    private DevHelperRegistryProperties registryProperties;

    @PostConstruct
    public void rewriteServiceId() {
        //服务注册时增加分组后缀
        nacosDiscoveryProperties.setService(DevHelperDiscoveryServiceIdUtils.buildRegistryServiceIdByGroup(nacosDiscoveryProperties.getService(), registryProperties.getGroup()));
    }
}
