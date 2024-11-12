package com.esprit.microservice.gestionvols.repositories;

import com.esprit.microservice.gestionvols.entites.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger,Long> {
}
