package com.esprit.microservice.gestionvols.controller;

import com.esprit.microservice.gestionvols.entites.FlightSchedule;
import com.esprit.microservice.gestionvols.services.FlightScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flightSchedules")
public class FlightScheduleController {
    @Autowired
    private FlightScheduleService flightScheduleService;

    @GetMapping
    public List<FlightSchedule> getAllFlightSchedules() {
        return flightScheduleService.getAllFlightSchedules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightSchedule> getFlightScheduleById(@PathVariable Long idFlightSchedule) {
        Optional<FlightSchedule> flightSchedule = flightScheduleService.getFlightScheduleById(idFlightSchedule);
        return flightSchedule.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public FlightSchedule createFlightSchedule(@RequestBody FlightSchedule flightSchedule) {
        return    flightScheduleService.saveFlightSchedule(flightSchedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightSchedule> updateFlightSchedule(@PathVariable Long id, @RequestBody FlightSchedule flightSchedule) {
        if (!flightScheduleService.getFlightScheduleById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        flightSchedule.setIdFlightSched(id);
        FlightSchedule updatedFlightSchedule = flightScheduleService.updateFlightSchedule(flightSchedule);
        return ResponseEntity.ok(updatedFlightSchedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlightSchedule(@PathVariable Long id) {
        if (!flightScheduleService.getFlightScheduleById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        flightScheduleService.deleteFlightSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
