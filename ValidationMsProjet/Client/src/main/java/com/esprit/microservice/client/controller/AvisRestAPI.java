package com.esprit.microservice.client.controller;


import com.esprit.microservice.client.model.Avis;
import com.esprit.microservice.client.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avis")
public class AvisRestAPI {
    @Autowired
    private AvisService avisService;

    @GetMapping
    public List<Avis> getAllAvis() {
        return avisService.findAllAvis();
    }
    @GetMapping("/search/byCommentaire")
    public Page<Avis> searchAvisByCommentaire(@RequestParam("commentaire") String commentaire,
                                              @RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return avisService.searchByCommentaire(commentaire, pageable);
    }
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Avis> createAvis(@RequestBody Avis avis) {
        Avis createdAvis = avisService.addAvis(avis);
        return new ResponseEntity<>(createdAvis, HttpStatus.CREATED);

    }

    @PutMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Avis> updateAvis(@PathVariable("id") Long id, @RequestBody Avis avis) {
        Avis updatedAvis = avisService.updateAvis(id, avis);
        if (updatedAvis != null) {
            return new ResponseEntity<>(updatedAvis, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteAvis(@PathVariable("id") Long id) {
        String response = avisService.deleteAvis(id);
        if (response.equals("Avis supprimé avec succès")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Avis> getAvisById(@PathVariable("id") Long id) {
        Optional<Avis> avis = avisService.getAvisById(id);
        return avis.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
