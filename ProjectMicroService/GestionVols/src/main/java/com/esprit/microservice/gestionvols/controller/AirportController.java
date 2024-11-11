package com.esprit.microservice.gestionvols.controller;

import com.esprit.microservice.gestionvols.entites.Airport;
import com.esprit.microservice.gestionvols.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long idAirport) {
        Optional<Airport> airport = airportService.getAirportById(idAirport);
        return airport.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Airport createAirport(@RequestBody Airport airport) {
        return    airportService.saveAirport(airport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable Long id, @RequestBody Airport airport) {
        if (!airportService.getAirportById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        airport.setIdAirport(id);
        Airport updatedAirport = airportService.updateAirport(airport);
        return ResponseEntity.ok(updatedAirport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        if (!airportService.getAirportById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        airportService.deleteAirport(id);
        return ResponseEntity.noContent().build();
    }
}
