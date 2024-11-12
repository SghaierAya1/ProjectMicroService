package com.esprit.microservice.gestionvols.repositories;

import com.esprit.microservice.gestionvols.entites.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepo extends JpaRepository<Airport,Long> {
}
