package com.esprit.microservice.gestionvols.repositories;

import com.esprit.microservice.gestionvols.entites.FlightSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightScheduleRepo extends JpaRepository<FlightSchedule,Long> {
}
