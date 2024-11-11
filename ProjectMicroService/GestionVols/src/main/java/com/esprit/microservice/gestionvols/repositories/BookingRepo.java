package com.esprit.microservice.gestionvols.repositories;

import com.esprit.microservice.gestionvols.entites.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {
}
