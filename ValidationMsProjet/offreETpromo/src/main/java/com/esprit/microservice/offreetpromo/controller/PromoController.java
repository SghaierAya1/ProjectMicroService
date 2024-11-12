package com.esprit.microservice.offreetpromo.controller;

import com.esprit.microservice.offreetpromo.entities.Promo;
import com.esprit.microservice.offreetpromo.service.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/promos")
public class PromoController {
    @Autowired
    private PromoService promoService;

    @PostMapping
    public ResponseEntity<Promo> createPromo(@RequestBody Promo promo) {
        return new ResponseEntity<>(promoService.addPromo(promo), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Promo> getAllPromos() {
        return promoService.getAllPromos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promo> getPromoById(@PathVariable int id) {
        Optional<Promo> promo = promoService.getPromoById(id);
        return promo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promo> updatePromo(@PathVariable int id, @RequestBody Promo promo) {
        Promo updatedPromo = promoService.updatePromo(id, promo);
        if (updatedPromo != null) {
            return new ResponseEntity<>(updatedPromo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePromo(@PathVariable int id) {
        return new ResponseEntity<>(promoService.deletePromo(id), HttpStatus.OK);
    }
}

