package cn.fxbin.learn.sca.nacos.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class ScaNacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScaNacosConsumerApplication.class, args);
    }

}
