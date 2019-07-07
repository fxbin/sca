package cn.fxbin.learn.sca.nacos.consumer.controller;

import cn.fxbin.learn.sca.nacos.consumer.client.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ConsumerController
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/7/7 20:36
 */
@Slf4j
@RestController
public class ConsumerController {

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/test")
    public String test() {
        return discoveryClient.echo(" !^@^! ");
    }

}
