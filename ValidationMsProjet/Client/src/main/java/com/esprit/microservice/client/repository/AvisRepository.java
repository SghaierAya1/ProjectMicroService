package com.esprit.microservice.client.repository;

import com.esprit.microservice.client.model.Avis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AvisRepository extends JpaRepository<Avis, Long> {

    // Requête personnalisée pour rechercher un avis par commentaire
    @Query("SELECT a FROM Avis a WHERE a.commentaire LIKE :commentaire")
    Page<Avis> findByCommentaire(@Param("commentaire") String commentaire, Pageable pageable);
}
