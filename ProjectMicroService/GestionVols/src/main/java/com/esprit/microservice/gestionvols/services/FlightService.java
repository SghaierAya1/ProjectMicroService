package com.esprit.microservice.gestionvols.services;

import com.esprit.microservice.gestionvols.entites.Flight;
import com.esprit.microservice.gestionvols.repositories.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService implements IFlightService{

    @Autowired
    FlightRepo flightRepo;

    @Override
    public List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }

    @Override
    public Optional getFlightById(long idFlight) {
        return flightRepo.findById(idFlight);
    }

    @Override
    public Flight saveFlight(Flight flight) {
        return  flightRepo.save(flight);

    }

    @Override
    public Flight updateFlight(Flight flight) {
       return flightRepo.save(flight);

    }

    @Override
    public void deleteFlight(long idFlight) {
        flightRepo.deleteById(idFlight);

    }
}
