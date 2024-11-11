package com.esprit.microservice.gestionvols.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Flight implements Serializable {

    private static final long serialVersionUID = 6;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFlight;

    private String flightNumber, status, aircraftType;
    private Double duration;
    private Integer availableSeats;
    private String departureCity;


    @ManyToOne
    private Airline airline;

    @ManyToOne
    private Airport origin;

    @ManyToOne
    private Airport destination;

    @OneToMany(mappedBy = "flight")
    private List<FlightSchedule> schedules;

    @OneToMany(mappedBy = "flight")
    private List<Booking> bookings;

    private Long getIdFlight(){
        return idFlight;
    }

    public void setIdFlight(Long idFlight) {
        this.idFlight = idFlight;
    }
    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }
    private String getFlightNumber(){
        return flightNumber;
    }
    private void setFlightNumber(String flightNumber){
        this.flightNumber = flightNumber;
    }
    private String getStatus(){
        return status;
    }
    private void setStatus(String status){
        this.status = status;
    }
    private String getAircraftType(){
        return aircraftType;
    }
    private void setAircraftType(String aircraftType){
        this.aircraftType = aircraftType;
    }
    private Double getDuration(){
        return duration;
    }
    private void setDuration(Double duration){
        this.duration = duration;
    }
    private Integer getAvailableSeats(){
        return availableSeats;
    }
    private void setAvailableSeats(Integer availableSeats){
        this.availableSeats = availableSeats;
    }

    public Flight(){super();}
    public Flight(String flightNumber ,String status,String aircraftType,Double duration,Integer availableSeats){
        super();
        this.flightNumber = flightNumber;
        this.status = status;
        this.aircraftType = aircraftType;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }


}
