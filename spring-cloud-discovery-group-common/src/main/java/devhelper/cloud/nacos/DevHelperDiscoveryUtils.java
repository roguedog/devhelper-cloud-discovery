package devhelper.cloud.nacos;

public class DevHelperDiscoveryUtils {
    public static final String PREFIX_GROUP = ".";

    public static String buildServiceIdByGroup(String serviceId, String group) {
        return serviceId + PREFIX_GROUP + group;
    }

}
