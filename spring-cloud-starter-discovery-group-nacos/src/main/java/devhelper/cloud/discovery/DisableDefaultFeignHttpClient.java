package devhelper.cloud.discovery;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * 让Feign的默认的HttpClient失效，以便自定义
 */
class DisableDefaultFeignHttpClient implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();
        Map<String, Object> systemProperties = environment.getSystemProperties();
        systemProperties.put("feign.httpclient.enabled", "false");
        systemProperties.put("feign.okhttp.enabled", "false");
    }
}
