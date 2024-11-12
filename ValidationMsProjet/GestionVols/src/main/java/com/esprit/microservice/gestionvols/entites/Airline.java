package com.esprit.microservice.gestionvols.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Airline implements Serializable {
    private static final long serialVersionUID = 6;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAirline;
    private String nom, code, country,contactInfo;

    @OneToMany(mappedBy = "airline")
    private List<Flight> flights;



    public Long getIdAirline() {
        return idAirline;
    }
    public void setIdAirline (Long idAirline) {
        this.idAirline = idAirline;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

   public String getContactInfo(){
        return contactInfo;
   }
   public void setContactInfo(String contactInfo){
        this.contactInfo = contactInfo;
   }

    public Airline(){
        super();
    }
    public Airline(String nom, String code,String contactInfo){
        super();
        this.nom=nom;
        this.code=code;
        this.contactInfo = contactInfo;
    }
}
