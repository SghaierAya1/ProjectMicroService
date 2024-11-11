package com.esprit.microservice.gestionvols.services;

import com.esprit.microservice.gestionvols.entites.Airport;
import com.esprit.microservice.gestionvols.repositories.AirportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService implements IAirportService{

    @Autowired
    AirportRepo airportRepo;

    @Override
    public List<Airport> getAllAirports() {
        return airportRepo.findAll();
    }

    @Override
    public Optional getAirportById(long idAirport) {
         return airportRepo.findById(idAirport);
    }

    @Override
    public Airport saveAirport(Airport airport) {
return airportRepo.save(airport);
    }

    @Override
    public Airport updateAirport(Airport airport) {
       return airportRepo.save(airport);
    }

    @Override
    public void deleteAirport(long idAirport) {
airportRepo.deleteById(idAirport);
    }
}
