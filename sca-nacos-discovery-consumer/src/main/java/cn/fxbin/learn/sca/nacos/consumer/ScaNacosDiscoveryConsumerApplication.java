package cn.fxbin.learn.sca.nacos.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class ScaNacosDiscoveryConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScaNacosDiscoveryConsumerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RestController
    public class ConsumerController {

        @Resource
        LoadBalancerClient loadBalancerClient;

        @Resource
        private RestTemplate restTemplate;


        @GetMapping(value = "/test")
        public String test() {

            // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
            ServiceInstance serviceInstance = loadBalancerClient.choose("sca-nacos-discovery-provider");
            String url = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), " !^@^! ");
            log.info("请求路径为：{}", url);
            return restTemplate.getForObject(url, String.class);
        }
    }


}
