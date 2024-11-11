package com.esprit.microservice.gestionvols.controller;

import com.esprit.microservice.gestionvols.entites.Flight;
import com.esprit.microservice.gestionvols.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long idFlight) {
        Optional<Flight> flight = flightService.getFlightById(idFlight);
        return flight.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return    flightService.saveFlight(flight);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        if (!flightService.getFlightById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        flight.setIdFlight(id);
        Flight updatedFlight = flightService.updateFlight(flight);
        return ResponseEntity.ok(updatedFlight);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        if (!flightService.getFlightById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }
}
