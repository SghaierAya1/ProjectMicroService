package com.esprit.microservice.client.service;

import com.esprit.microservice.client.model.Avis;
import com.esprit.microservice.client.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AvisService {
    @Autowired
    private AvisRepository avisRepository;

    public List<Avis> findAllAvis() {
        return avisRepository.findAll();
    }

    public Avis addAvis(Avis avis) {
        return avisRepository.save(avis);
    }

    public Avis updateAvis(Long id, Avis newAvis) {
        Optional<Avis> existingAvisOpt = avisRepository.findById(id);

        if (existingAvisOpt.isPresent()) {
            Avis existingAvis = existingAvisOpt.get();
            existingAvis.setCommentaire(newAvis.getCommentaire());
            existingAvis.setNote(newAvis.getNote());
            existingAvis.setUtilisateurId(newAvis.getUtilisateurId());
            existingAvis.setVoyageId(newAvis.getVoyageId());
            return avisRepository.save(existingAvis);
        } else {
            return null;
        }
    }
    public Optional<Avis> getAvisById(Long id) {
        return avisRepository.findById(id);
    }
    // Méthode pour rechercher les avis par commentaire avec pagination
    public Page<Avis> searchByCommentaire(String commentaire, Pageable pageable) {
        return avisRepository.findByCommentaire("%" + commentaire + "%", pageable); // Recherche partielle
    }

    public String deleteAvis(Long id) {
        if (avisRepository.findById(id).isPresent()) {
            avisRepository.deleteById(id);
            return "Avis supprimé avec succès";
        } else {
            return "Avis introuvable";
        }
    }
}
