package com.esprit.microservice.gestionvols.services;

import com.esprit.microservice.gestionvols.entites.Passenger;
import com.esprit.microservice.gestionvols.repositories.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService implements IPassengerService{

    @Autowired
    PassengerRepo passengerRepo;

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepo.findAll();
    }

    @Override
    public Optional getPassengerById(long idPassenger) {
        return passengerRepo.findById(idPassenger);
    }

    @Override
    public Passenger savePassenger(Passenger passenger) {
        return passengerRepo.save(passenger);

    }

    @Override
    public Passenger updatePassenger(Passenger passenger) {
        return passengerRepo.save(passenger);

    }

    @Override
    public void deletePassenger(long idPassenger) {
        passengerRepo.deleteById(idPassenger);

    }
}
