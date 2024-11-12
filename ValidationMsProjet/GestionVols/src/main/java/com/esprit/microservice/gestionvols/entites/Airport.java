package com.esprit.microservice.gestionvols.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Airport implements Serializable {
    private static final long serialVersionUID = 6;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Long idAirport;

    private String name,city,country;

    public Long getIdAirport() {
        return idAirport;
    }
    public void setIdAirport(Long idAirport) {
        this.idAirport = idAirport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "origin")
    private List<Flight> departureFlights;

    @OneToMany(mappedBy = "destination")
    private List<Flight> arrivalFlights;

    public Airport(){
        super();
    }
    public Airport(String name, String city,String country){
        super();
        this.name = name;
        this.city = city;
        this.country= country;
    }
}
