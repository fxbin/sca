package cn.fxbin.learn.sca.nacos.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;

    @GetMapping(value = "/test")
    public String test() {

        String url = String.format("http://%s/echo/%s", "sca-nacos-discovery-provider", " !^@^! ");
        log.info("请求路径为：{}", url);
        return restTemplate.getForObject(url, String.class);
    }

}
