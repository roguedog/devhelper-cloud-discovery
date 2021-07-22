package devhelper.cloud.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "dev-helper.cloud.discovery")
public class DiscoveryProperties {

    private final Map<String,String> group =new HashMap<>();

    public Map<String, String> getGroup() {
        return group;
    }

}
