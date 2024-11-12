package com.tn.esprit.validationmsprojet;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class ValidationMsProjetApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidationMsProjetApplication.class, args);
    }

}
