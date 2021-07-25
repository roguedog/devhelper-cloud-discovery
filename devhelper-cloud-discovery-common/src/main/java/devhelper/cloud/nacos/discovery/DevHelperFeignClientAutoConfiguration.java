package devhelper.cloud.nacos.discovery;

import feign.Client;
import feign.okhttp.OkHttpClient;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.clientconfig.OkHttpFeignConfiguration;
import org.springframework.cloud.openfeign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * feign远程调用重写配置
 * @author zhangkai
 */
@Configuration(
        proxyBeanMethods = false
)
@ConditionalOnClass({OkHttpClient.class})
@ConditionalOnProperty(value = {"devhelper.cloud.discovery.enabled"}, matchIfMissing = false)
@AutoConfigureBefore(FeignAutoConfiguration.class)
@EnableConfigurationProperties(DevHelperDiscoveryProperties.class)
@Import({OkHttpFeignConfiguration.class})
public class DevHelperFeignClientAutoConfiguration {

    DevHelperFeignClientAutoConfiguration() {
    }

    @Bean
    @ConditionalOnMissingBean({Client.class})
    public Client feignClient(CachingSpringLoadBalancerFactory cachingFactory, SpringClientFactory clientFactory, okhttp3.OkHttpClient okHttpClient, DevHelperDiscoveryProperties discoveryProperties) {
        OkHttpClient delegate = new OkHttpClient(okHttpClient);
        return new DevHelperLoadBalancerFeignClient(delegate, cachingFactory, clientFactory, discoveryProperties);
    }

}
