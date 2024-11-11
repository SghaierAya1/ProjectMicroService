package com.esprit.microservice.offreetpromo.service;

import com.esprit.microservice.offreetpromo.entities.Offre;
import com.esprit.microservice.offreetpromo.repository.OffreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffreService {
    @Autowired
    private OffreRepo offreRepository;

    public Offre addOffre(Offre offre) {
        return offreRepository.save(offre);
    }

    public Offre updateOffre(int id, Offre newOffre) {
        return offreRepository.findById(id).map(offre -> {
            offre.setDescription(newOffre.getDescription());
            offre.setDiscount(newOffre.getDiscount());
            offre.setDateStart(newOffre.getDateStart());
            offre.setDateEnd(newOffre.getDateEnd());
            offre.setDestination(newOffre.getDestination());
            offre.setIsActive(newOffre.getIsActive());
            return offreRepository.save(offre);
        }).orElse(null);
    }

    public String deleteOffre(int id) {
        if (offreRepository.existsById(id)) {
            offreRepository.deleteById(id);
            return "Offre supprimée";
        }
        return "Offre non trouvée";
    }

    public List<Offre> getAllOffres() {
        return offreRepository.findAll();
    }

    public Optional<Offre> getOffreById(int id) {
        return offreRepository.findById(id);
    }
}

