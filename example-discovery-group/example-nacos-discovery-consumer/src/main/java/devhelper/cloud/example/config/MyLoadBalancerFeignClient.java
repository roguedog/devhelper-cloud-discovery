package devhelper.cloud.example.config;

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
 * feign远程调用重写
 */
public class MyLoadBalancerFeignClient extends LoadBalancerFeignClient {
    private final Map<String,String> groupConfig = new HashMap<>();
    public MyLoadBalancerFeignClient(Client delegate, CachingSpringLoadBalancerFactory lbClientFactory, SpringClientFactory clientFactory, DiscoveryProperties discoveryProperties) {
        super(delegate, lbClientFactory, clientFactory);
        groupConfig.putAll(discoveryProperties.getGroup());
    }

    @Override
    public Response execute(Request request, Request.Options options) throws IOException {
        String url = request.url();
        URI asUri = URI.create(url);
        String clientName = asUri.getHost();
        String groupName = groupConfig.get(clientName);
        if (!StringUtils.isEmpty(groupName)) {
            String newUrl = replaceUrl(url, clientName, groupName);
            request = Request.create(request.httpMethod(),
                    newUrl, request.headers(), request.body(), request.charset(), request.requestTemplate()
            );
        }
        return super.execute(request, options);
    }

    String replaceUrl(String originalUrl, String clientName, String groupName) {
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
        StringBuffer buffer = new StringBuffer(prefix + clientName + "-" + groupName + suffix);
        if (newUrl.startsWith("https://") && newUrl.length() == 8 || newUrl.startsWith("http://") && newUrl.length() == 7) {
            buffer.append("/");
        }

        return buffer.toString();
    }
}
