package com.esprit.microservice.gestionvols.services;

import com.esprit.microservice.gestionvols.entites.Airport;

import java.util.List;
import java.util.Optional;

public interface IAirportService {
    List<Airport> getAllAirports();
    Optional getAirportById(long idAirport);
    Airport saveAirport(Airport airport);
    Airport updateAirport(Airport airport);
    void deleteAirport(long idAirport);
}
