package devhelper.cloud.example;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.registry.NacosServiceRegistryAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ConditionalOnProperty(value = {"xxx.cloud.discovery.group.enabled"}, matchIfMissing = false)
@AutoConfigureBefore(NacosServiceRegistryAutoConfiguration.class)
@AutoConfigureAfter(NacosDiscoveryProperties.class)
public class NacosDiscoveryServiceNameOverwrite {
    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @PostConstruct
    public void rewriteServiceId() {
        System.out.println(1);
        nacosDiscoveryProperties.setService(nacosDiscoveryProperties.getService() + "-group1");
    }
}
