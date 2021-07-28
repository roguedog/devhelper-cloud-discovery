package devhelper.cloud.nacos;

import org.springframework.util.StringUtils;

import java.net.InetAddress;

/**
 * service id拼接后缀
 * @author zhangkai
 */
public class DevHelperDiscoveryServiceIdUtils {
    public static final String DOT = ".";
    private static String DEFAULT_SUFFIX;

    static {
        try {
            DEFAULT_SUFFIX = System.getProperty("user.name");
            if (StringUtils.isEmpty(DEFAULT_SUFFIX)) {
                DEFAULT_SUFFIX = InetAddress.getLocalHost().getHostName();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String buildRegistryServiceIdBySuffix(String serviceId, String suffix) {
        if (StringUtils.isEmpty(suffix)) {
            suffix = DEFAULT_SUFFIX;
        }
        return buildServiceIdBySuffix(serviceId, suffix);
    }

    public static String getDiscoveryServiceIdBySuffix(String serviceId, String suffix) {
        if (StringUtils.isEmpty(suffix)) {
            return serviceId;
        }
        return buildServiceIdBySuffix(serviceId, suffix);
    }

    public static String buildServiceIdBySuffix(String serviceId, String suffix) {
        return serviceId + DOT + suffix;
    }

}
