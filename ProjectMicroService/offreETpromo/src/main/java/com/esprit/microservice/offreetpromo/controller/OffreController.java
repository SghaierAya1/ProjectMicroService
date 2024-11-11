package com.esprit.microservice.offreetpromo.controller;

import com.esprit.microservice.offreetpromo.entities.Offre;
import com.esprit.microservice.offreetpromo.service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/offres")
public class OffreController {
    @Autowired
    private OffreService offreService;

    @PostMapping
    public ResponseEntity<Offre> createOffre(@RequestBody Offre offre) {
        return new ResponseEntity<>(offreService.addOffre(offre), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Offre> getAllOffres() {
        return offreService.getAllOffres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offre> getOffreById(@PathVariable int id) {
        Optional<Offre> offre = offreService.getOffreById(id);
        return offre.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Offre> updateOffre(@PathVariable int id, @RequestBody Offre offre) {
        Offre updatedOffre = offreService.updateOffre(id, offre);
        if (updatedOffre != null) {
            return new ResponseEntity<>(updatedOffre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOffre(@PathVariable int id) {
        return new ResponseEntity<>(offreService.deleteOffre(id), HttpStatus.OK);
    }
}

