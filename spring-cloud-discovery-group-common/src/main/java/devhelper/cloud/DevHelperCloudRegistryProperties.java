package devhelper.cloud;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dev-helper.cloud.discovery")
public
class DevHelperCloudRegistryProperties {

    private String group;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
