package cn.fxbin.learn.sca.nacos.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ScaNacosConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScaNacosConfigApplication.class, args);
    }

    @RefreshScope
    @RestController
    public class ConfigController {

        @Value("${config.test}")
        private String configTest;

        @GetMapping("/config")
        public String configTest() {
            return configTest;
        }
    }

}
