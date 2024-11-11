package com.esprit.microservice.gestionvols.repositories;

import com.esprit.microservice.gestionvols.entites.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long> {
}
