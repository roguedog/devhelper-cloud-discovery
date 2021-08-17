package io.github.roguedog.devhelper.cloud.discovery;

import io.github.roguedog.devhelper.cloud.DevHelperDiscoveryServiceIdUtils;
import feign.Client;
import feign.Request;
import feign.Response;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.cloud.openfeign.ribbon.LoadBalancerFeignClient;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * feign远程调用重写, 替换clientName
 * @author zhangkai
 */
class DevHelperLoadBalancerFeignClient extends LoadBalancerFeignClient {

    private final Map<String,String> suffixConfig = new HashMap<>();
    public DevHelperLoadBalancerFeignClient(Client delegate, CachingSpringLoadBalancerFactory lbClientFactory, SpringClientFactory clientFactory, DevHelperDiscoveryProperties discoveryProperties) {
        super(delegate, lbClientFactory, clientFactory);
        suffixConfig.putAll(discoveryProperties.getSuffix());
    }

    @Override
    public Response execute(Request request, Request.Options options) throws IOException {
        String url = request.url();
        URI asUri = URI.create(url);
        String clientName = asUri.getHost();
        String suffixName = suffixConfig.get(clientName);
        if (!StringUtils.isEmpty(suffixName)) {
            String newUrl = replaceUrl(url, clientName, suffixName);
            request = Request.create(request.httpMethod(),
                    newUrl, request.headers(), request.body(), request.charset(), request.requestTemplate()
            );
        }
        return super.execute(request, options);
    }

    String replaceUrl(String originalUrl, String clientName, String suffixName) {
        String newUrl = originalUrl;
        String prefix = "";
        String suffix = "";
        if (originalUrl.startsWith("https://")) {
            prefix = originalUrl.substring(0, 8);
            suffix = originalUrl.substring(8 + clientName.length());
        } else if (originalUrl.startsWith("http")) {
            prefix = originalUrl.substring(0, 7);
            suffix = originalUrl.substring(7 + clientName.length());
        }
        StringBuffer buffer = new StringBuffer(prefix + DevHelperDiscoveryServiceIdUtils.getDiscoveryServiceIdBySuffix(clientName, suffixName) + suffix);
        if (newUrl.startsWith("https://") && newUrl.length() == 8 || newUrl.startsWith("http://") && newUrl.length() == 7) {
            buffer.append("/");
        }

        return buffer.toString();
    }
}
