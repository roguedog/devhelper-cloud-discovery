package devhelper.cloud.nacos.registry;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "devhelper.cloud.registry")
public class DevHelperRegistryProperties {

    private String group;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
