package com.esprit.microservice.offreetpromo.repository;

import com.esprit.microservice.offreetpromo.entities.Promo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PromoRepo extends JpaRepository<Promo, Integer> {
    List<Promo> findByIsActive(Boolean isActive);
}
