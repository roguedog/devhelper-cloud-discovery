package devhelper.cloud.eureka.discovery;

import devhelper.cloud.nacos.DevHelperDiscoveryServiceIdUtils;
import devhelper.cloud.nacos.registry.DevHelperRegistryProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;

/**
 * 类的描述
 *
 * @author: yuzicheng
 * @since: 7/28/21 6:10 下午
 */
public class EurekaConfigBeanPostProcessor implements BeanPostProcessor {

    private DevHelperRegistryProperties registryProperties;

    public EurekaConfigBeanPostProcessor(DevHelperRegistryProperties registryProperties) {
        this.registryProperties = registryProperties;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof EurekaInstanceConfigBean) {
            EurekaInstanceConfigBean configBean = (EurekaInstanceConfigBean) bean;
            String appName = configBean.getAppname();
            String newAppName = DevHelperDiscoveryServiceIdUtils.buildRegistryServiceIdByGroup(appName, registryProperties.getGroup());

            configBean.setAppname(newAppName);
            configBean.setSecureVirtualHostName(newAppName);
            configBean.setVirtualHostName(newAppName);
        }
        return bean;
    }
}
