package com.esprit.microservice.gestionvols.entites;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Ticket implements Serializable {

    private static final long serialVersionUID = 6;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;

    private String ticketNumber , seatNumber;
    private float price;

    @ManyToOne
    private Booking booking;

    private Long getIdTicket(){
        return idTicket;
    }
    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }
    private String getTicketNumber(){
        return ticketNumber;
    }
    private void setTicketNumber(String ticketNumber){
        this.ticketNumber = ticketNumber;
    }
    private String getSeatNumber(){
        return seatNumber;
    }
    private void setSeatNumber(String seatNumber){
        this.seatNumber = seatNumber;
    }
    private float getPrice(){
        return price;
    }
    private void setPrice(float price){
       this.price=price;
    }
    public Ticket (){super();}
    public Ticket(String ticketNumber, String seatNumber, float price){
        super();
        this.ticketNumber = ticketNumber;
        this.seatNumber = ticketNumber;
        this.price = price;
    }

}

