package io.github.roguedog.devhelper.cloud.discovery;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangkai
 */
@ConfigurationProperties(prefix = "devhelper.cloud.discovery")
class DevHelperDiscoveryProperties {

    private final Map<String,String> suffix =new HashMap<>();

    public Map<String, String> getSuffix() {
        return suffix;
    }
}
