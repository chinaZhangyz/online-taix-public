package com.zyz.api.apipassenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ApiPasserngerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiPasserngerApplication.class, args);
    }
}
