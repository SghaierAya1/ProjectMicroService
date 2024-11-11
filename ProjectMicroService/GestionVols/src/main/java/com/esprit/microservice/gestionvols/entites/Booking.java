package com.esprit.microservice.gestionvols.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Booking implements Serializable {
    private static final long serialVersionUID = 6;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idBooking;

    private String status;
    private float totalPrice;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    public enum BookingStatus {
        PENDING, CONFIRMED, CANCELED
    }

    @ManyToOne
    private Flight flight;

    @ManyToOne
    private Passenger passenger;
    @OneToMany(mappedBy = "booking")
    private List<Ticket> tickets;


    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate;

    private Long getIdBooking(){
        return idBooking;
    }
    public void setIdBooking(Long idBooking) {
        this.idBooking = idBooking;
    }

    private String getStatus(){
        return status;
    }
    private void setStatus(String status){
        this.status = status;
    }
    private float getTotalPrice(){
        return totalPrice;
    }
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    private void setTotalPrice(float totalPrice){
    this.totalPrice = totalPrice;
    }
    private BookingStatus getBookingStatus(){
        return bookingStatus;
    }
    public void setBookingStatus(BookingStatus bookingStatus){
        this.bookingStatus = bookingStatus;
    }
    public Booking (){super();}
    public Booking (String status,float totalPrice){
        super();
        this.status = status;
        this.totalPrice = totalPrice;
    }
}
