package devhelper.cloud.nacos;

import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DevHelperDiscoveryServiceIdUtils {
    public static final String PREFIX_GROUP = ".";
    private static String DEFAULT_GROUP;

    static {
        try {
            DEFAULT_GROUP = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static String buildRegistryServiceIdByGroup(String serviceId, String group) {
        if (StringUtils.isEmpty(group)) {
            group = DEFAULT_GROUP;
        }
        return buildServiceIdByGroup(serviceId, group);
    }

    public static String getDiscoveryServiceIdByGroup(String serviceId, String group) {
        if (StringUtils.isEmpty(group)) {
            return serviceId;
        }
        return buildServiceIdByGroup(serviceId, group);
    }

    public static String buildServiceIdByGroup(String serviceId, String group) {
        return serviceId + PREFIX_GROUP + group;
    }

}
