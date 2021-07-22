package devhelper.cloud.discovery;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "dev-helper.cloud.discovery")
class DevHelperCloudDiscoveryProperties {

    private final Map<String,String> group =new HashMap<>();

    public Map<String, String> getGroup() {
        return group;
    }

}
