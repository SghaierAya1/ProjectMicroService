package com.esprit.microservice.gestionvols.services;

import com.esprit.microservice.gestionvols.entites.Airline;

import java.util.List;
import java.util.Optional;

public interface IAirlineService {

    List<Airline> getAllAirlines();
    Optional getAirlineById(Long idAirline);
    Airline  saveAirline(Airline airline);
    Airline updateAirline(Airline airline);
    void deleteAirline(Long idAirline);
}
