package com.esprit.microservice.gestionvols.entites;

import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Booking booking;

    private Double amount;
    private String paymentStatus;

    private Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    private String getPaymentStatus(){
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus){
        this.paymentStatus = paymentStatus;
    }
    private Booking getBooking(){
        return booking;
    }
    public void setBooking(Booking booking){
        this.booking = booking;
    }



    private Double getAmount(){
        return amount;
    }
    public void setAmount(Double amount){
        this.amount = amount;
    }


}
