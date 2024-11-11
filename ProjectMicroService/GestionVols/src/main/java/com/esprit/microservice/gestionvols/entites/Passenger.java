package com.esprit.microservice.gestionvols.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Passenger implements Serializable {
    private static final long serialVersionUID = 6;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPassenger;

    private String firstName,lastName,email,phone,passportNumber;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings;

    private Long getIdPassenger(){
        return idPassenger;
    }
    public void setIdPassenger(Long idPassenger) {
        this.idPassenger = idPassenger;
    }
    private String getFirstName(){
        return firstName;
    }
    private void setFirstName(String firstName){
        this.firstName = firstName;
    }
    private String getLastName(){
        return lastName;
    }
    private void setLastName(String lastName){
        this.lastName = lastName;
    }
    private String getEmail(){
        return email;
    }
    private void setEmail(String email){
        this.email = email;
    }
    private String getPhone(){
        return phone;
    }
    private void setPhone(String phone){
        this.phone = phone;
    }
    private String getPassportNumber(){
        return passportNumber;
    }
    private void setPassportNumber(String passportNumber){
        this.passportNumber = passportNumber;
    }
    public Passenger(){
        super();
    }
    public Passenger(String firstName,String lastName,String email , String phone,String passportNumber){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.passportNumber = passportNumber;
    }


}
