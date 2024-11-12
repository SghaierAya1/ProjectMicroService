package com.esprit.microservice.gestionvols.repositories;

import com.esprit.microservice.gestionvols.entites.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,Long> {
}
