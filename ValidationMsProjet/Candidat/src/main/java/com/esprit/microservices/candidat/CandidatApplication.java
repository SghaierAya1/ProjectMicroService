package com.esprit.microservices.candidat;

import com.esprit.microservices.candidat.entities.Hotel;
import com.esprit.microservices.candidat.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CandidatApplication {

    public static void main(String[] args) {
        SpringApplication.run(CandidatApplication.class, args);
    }
    @Autowired
    private HotelRepo repository;

    @Bean
    ApplicationRunner init() {
        return (args) -> {
            if (repository.count() == 0) {  // Only save if there are no records
                repository.save(new Hotel("Hotel Ritz", "Paris, France", 5, 350.0, true, "Suite", new Date(), new Date()));
                repository.save(new Hotel("Hotel Plaza", "New York, USA", 4, 250.0, true, "Double", new Date(), new Date()));
                repository.save(new Hotel("Hotel Royal", "London, UK", 3, 150.0, true, "Simple", new Date(), new Date()));
                repository.save(new Hotel("Hotel Mediterranean", "Rome, Italy", 5, 400.0, false, "Suite", new Date(), new Date()));
            }
        };
    }
    }
