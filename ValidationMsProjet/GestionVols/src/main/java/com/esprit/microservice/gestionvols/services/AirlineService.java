package com.esprit.microservice.gestionvols.services;

import com.esprit.microservice.gestionvols.entites.Airline;
import com.esprit.microservice.gestionvols.repositories.AirlineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineService implements IAirlineService{

    @Autowired
    AirlineRepo airlineRepo;


    @Override
    public List<Airline> getAllAirlines() {
        return airlineRepo.findAll();
    }

    @Override
    public Optional getAirlineById(Long idAirline) {
        return airlineRepo.findById(idAirline);
    }

    @Override
    public Airline  saveAirline(Airline airline) {
return  airlineRepo.save(airline);
    }

    @Override
    public Airline  updateAirline(Airline airline) {
       return airlineRepo.save(airline);

    }

    @Override
    public void deleteAirline(Long idAirline) {
        airlineRepo.deleteById(idAirline);

    }
}
