package com.esprit.microservice.gestionvols.controller;

import com.esprit.microservice.gestionvols.entites.Passenger;
import com.esprit.microservice.gestionvols.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long idPassenger) {
        Optional<Passenger> passenger = passengerService.getPassengerById(idPassenger);
        return passenger.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return    passengerService.savePassenger(passenger);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
        if (!passengerService.getPassengerById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        passenger.setIdPassenger(id);
        Passenger updatedPassenger = passengerService.updatePassenger(passenger);
        return ResponseEntity.ok(updatedPassenger);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        if (!passengerService.getPassengerById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        passengerService.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }
}
