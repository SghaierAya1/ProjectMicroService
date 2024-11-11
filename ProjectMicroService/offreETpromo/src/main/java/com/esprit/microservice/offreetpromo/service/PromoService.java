package com.esprit.microservice.offreetpromo.service;

import com.esprit.microservice.offreetpromo.entities.Promo;
import com.esprit.microservice.offreetpromo.repository.PromoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PromoService {
    @Autowired
    private PromoRepo promoRepository;

    public Promo addPromo(Promo promo) {
        return promoRepository.save(promo);
    }

    public Promo updatePromo(int id, Promo newPromo) {
        return promoRepository.findById(id).map(promo -> {
            promo.setDescription(newPromo.getDescription());
            promo.setDiscount(newPromo.getDiscount());
            promo.setDateStart(newPromo.getDateStart());
            promo.setDateEnd(newPromo.getDateEnd());
            promo.setIsActive(newPromo.getIsActive());
            return promoRepository.save(promo);
        }).orElse(null);
    }

    public String deletePromo(int id) {
        if (promoRepository.existsById(id)) {
            promoRepository.deleteById(id);
            return "Promo supprimée";
        }
        return "Promo non trouvée";
    }

    public List<Promo> getAllPromos() {
        return promoRepository.findAll();
    }

    public Optional<Promo> getPromoById(int id) {
        return promoRepository.findById(id);
    }
}
