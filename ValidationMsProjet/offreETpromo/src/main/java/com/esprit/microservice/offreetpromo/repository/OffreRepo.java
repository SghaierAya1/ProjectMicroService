package com.esprit.microservice.offreetpromo.repository;

import com.esprit.microservice.offreetpromo.entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffreRepo extends JpaRepository<Offre, Integer> {
    List<Offre> findByDestination(String destination);
    List<Offre> findByIsActive(Boolean isActive);
}
