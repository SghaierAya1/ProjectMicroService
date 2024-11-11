package com.esprit.microservice.gestionvols.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class FlightSchedule implements Serializable {
    private static final long serialVersionUID = 6;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFlightSched;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String status;

    @ManyToOne
    private Flight flight;

    private Long getIdFlightSched() {
        return idFlightSched;
    }
    public void setIdFlightSched(Long idFlightSched) {
        this.idFlightSched = idFlightSched;
    }

    private String getStatus() {
        return status;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    private LocalDateTime getDepartureTime() {
        return departureTime;
    }

    private void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    private LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    private void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public FlightSchedule(){super();}
    public FlightSchedule(String status,LocalDateTime departureTime,LocalDateTime arrivalTime){
        super();
        this.status = status;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }
}
