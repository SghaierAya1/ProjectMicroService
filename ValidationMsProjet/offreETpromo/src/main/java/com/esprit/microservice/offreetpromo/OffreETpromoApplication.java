package com.esprit.microservice.offreetpromo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OffreETpromoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OffreETpromoApplication.class, args);
    }

}
