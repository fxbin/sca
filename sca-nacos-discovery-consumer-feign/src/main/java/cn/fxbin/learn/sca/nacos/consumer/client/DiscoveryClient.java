package cn.fxbin.learn.sca.nacos.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * DiscoveryClient
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/7/7 22:47
 */
@FeignClient("sca-nacos-discovery-provider")
public interface DiscoveryClient {

    @GetMapping(value = "/echo/{message}")
    String echo(@PathVariable String message);

}
