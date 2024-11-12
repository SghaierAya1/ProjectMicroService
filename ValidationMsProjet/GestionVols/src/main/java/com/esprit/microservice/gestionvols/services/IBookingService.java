package com.esprit.microservice.gestionvols.services;

import com.esprit.microservice.gestionvols.entites.Booking;

import java.util.List;
import java.util.Optional;

public interface IBookingService {
    List<Booking> getAllBookings();
    Optional getBookingById(long idBooking);
    Booking saveBooking(Booking booking);
    Booking updateBooking(Booking booking);
    void deleteBooking(long idBooking);
}
