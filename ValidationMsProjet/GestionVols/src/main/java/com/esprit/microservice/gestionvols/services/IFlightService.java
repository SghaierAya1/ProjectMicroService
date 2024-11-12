package com.esprit.microservice.gestionvols.services;

import com.esprit.microservice.gestionvols.entites.Flight;

import java.util.List;
import java.util.Optional;

public interface IFlightService {

    List<Flight> getAllFlights();
    Optional getFlightById(long idFlight);
    Flight saveFlight(Flight flight);
    Flight updateFlight(Flight flight);
    void deleteFlight(long idFlight);
}
