package com.esprit.microservice.gestionvols.repositories;

import com.esprit.microservice.gestionvols.entites.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepo extends JpaRepository<Airline,Long> {
}
