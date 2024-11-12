package com.esprit.microservice.gestionvols.controller;

import com.esprit.microservice.gestionvols.entites.Airline;
import com.esprit.microservice.gestionvols.services.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airlines")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping
    public List<Airline> getAllAirlines() {
        return airlineService.getAllAirlines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airline> getAirlineById(@PathVariable Long idAirline) {
        Optional<Airline> airline = airlineService.getAirlineById(idAirline);
        return airline.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Airline createAirline(@RequestBody Airline airline) {
      return    airlineService.saveAirline(airline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airline> updateAirline(@PathVariable Long id, @RequestBody Airline airline) {
        if (!airlineService.getAirlineById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        airline.setIdAirline(id);
        Airline updatedAirline = airlineService.updateAirline(airline);
        return ResponseEntity.ok(updatedAirline);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirline(@PathVariable Long id) {
        if (!airlineService.getAirlineById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        airlineService.deleteAirline(id);
        return ResponseEntity.noContent().build();
    }
}
