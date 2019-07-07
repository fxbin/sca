package cn.fxbin.learn.sca.nacos.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ScaNacosFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScaNacosFeignApplication.class, args);
    }

}
