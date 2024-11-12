package com.esprit.microservice.gestionvols.repositories;

import com.esprit.microservice.gestionvols.entites.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<Flight,Long> {
}
