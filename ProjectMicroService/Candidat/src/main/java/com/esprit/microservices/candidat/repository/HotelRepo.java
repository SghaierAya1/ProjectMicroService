package com.esprit.microservices.candidat.repository;


import com.esprit.microservices.candidat.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@Repository
public interface HotelRepo extends JpaRepository<Hotel,Integer> {
    @Query("select c from Hotel c where c.nom like :name")
    public Page<Hotel> candidatByNom(@Param("name") String n, Pageable pageable);
}
