package io.github.roguedog.devhelper.cloud.registry;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhangkai
 */
@ConfigurationProperties(prefix = "devhelper.cloud.registry")
public class DevHelperRegistryProperties {

    private String suffix;

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
