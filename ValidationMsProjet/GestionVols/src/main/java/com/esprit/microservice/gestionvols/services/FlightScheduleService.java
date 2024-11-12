package com.esprit.microservice.gestionvols.services;

import com.esprit.microservice.gestionvols.entites.FlightSchedule;
import com.esprit.microservice.gestionvols.repositories.FlightScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightScheduleService implements IFlightScheduleService{

    @Autowired
    FlightScheduleRepo flightScheduleRepo;

    @Override
    public List<FlightSchedule> getAllFlightSchedules() {
        return flightScheduleRepo.findAll();
    }

    @Override
    public Optional getFlightScheduleById(long idFlightSched) {
        return flightScheduleRepo.findById(idFlightSched);
    }

    @Override
    public FlightSchedule saveFlightSchedule(FlightSchedule flightSchedule) {
        return flightScheduleRepo.save(flightSchedule);

    }

    @Override
    public FlightSchedule updateFlightSchedule(FlightSchedule flightSchedule) {
        return flightScheduleRepo.save(flightSchedule);

    }

    @Override
    public void deleteFlightSchedule(long idFlightSched) {
        flightScheduleRepo.deleteById(idFlightSched);

    }
}
