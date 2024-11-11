package com.esprit.microservice.gestionvols.services;

import com.esprit.microservice.gestionvols.entites.Flight;
import com.esprit.microservice.gestionvols.entites.FlightSchedule;

import java.util.List;
import java.util.Optional;

public interface IFlightScheduleService {

    List<FlightSchedule> getAllFlightSchedules();
    Optional getFlightScheduleById(long idFlightSched);
    FlightSchedule saveFlightSchedule(FlightSchedule flightSchedule);
    FlightSchedule updateFlightSchedule(FlightSchedule flightSchedule);
    void deleteFlightSchedule(long idFlightSched);
}
