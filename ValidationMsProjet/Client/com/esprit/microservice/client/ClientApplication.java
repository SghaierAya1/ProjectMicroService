package com.esprit.microservice.client;

import com.esprit.microservice.client.model.Avis;
import com.esprit.microservice.client.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	@Autowired
	private AvisRepository repository;

	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// Ajouter des exemples d'avis
			repository.save(new Avis("Très bon service", 5, 1L, 101L));
			repository.save(new Avis("Service correct", 3, 2L, 102L));
			repository.save(new Avis("Mauvais service", 1, 3L, 103L));
			repository.save(new Avis("Excellent!", 5, 4L, 104L));

			// Afficher tous les avis
			repository.findAll().forEach(System.out::println);
		};
	}
}
