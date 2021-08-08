package com.projet.soabesoinservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class SoaBesoinServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoaBesoinServiceApplication.class, args);
    }

}
