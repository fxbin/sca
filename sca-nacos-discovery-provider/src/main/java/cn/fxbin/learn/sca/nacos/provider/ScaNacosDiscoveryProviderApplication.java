package cn.fxbin.learn.sca.nacos.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class ScaNacosDiscoveryProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScaNacosDiscoveryProviderApplication.class, args);
    }

    @RestController
    public class EchoController {

        @Value("${server.port}")
        private String port;

        @GetMapping(value = "/echo/{message}")
        public String echo(@PathVariable String message) {
            return "Hello Nacos Discovery Provider : " + message + ", port :" + port;
        }
    }

}
