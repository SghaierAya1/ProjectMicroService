package com.esprit.microservice.gestionvols.services;

import com.esprit.microservice.gestionvols.entites.Passenger;

import java.util.List;
import java.util.Optional;

public interface IPassengerService {

    List<Passenger> getAllPassengers();
    Optional getPassengerById(long idPassenger);
    Passenger savePassenger(Passenger passenger);
    Passenger updatePassenger(Passenger passenger);
    void deletePassenger(long idPassenger);
    
}
