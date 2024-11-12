package com.esprit.microservice.gestionvols.services;

import com.esprit.microservice.gestionvols.entites.Booking;
import com.esprit.microservice.gestionvols.entites.Flight;
import com.esprit.microservice.gestionvols.entites.Passenger;
import com.esprit.microservice.gestionvols.repositories.BookingRepo;
import com.esprit.microservice.gestionvols.repositories.FlightRepo;
import com.esprit.microservice.gestionvols.repositories.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements IBookingService{

    @Autowired
    BookingRepo bookingRepo;
    @Autowired
    private FlightRepo flightRepository;

    @Autowired
    private PassengerRepo passengerRepository;

    public Booking createBooking(Long passengerId, Long flightId) {
        Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new RuntimeException("Flight not found"));
        Passenger passenger = passengerRepository.findById(passengerId).orElseThrow(() -> new RuntimeException("Passenger not found"));

        Booking booking = new Booking();
        booking.setFlight(flight);
        booking.setPassenger(passenger);
        booking.setBookingStatus(Booking.BookingStatus.PENDING);  // Initialement en attente
        return bookingRepo.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public Optional getBookingById(long idBooking) {
         return  bookingRepo.findById(idBooking);
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return  bookingRepo.save(booking);

    }

    @Override
    public Booking updateBooking(Booking booking) {
      return bookingRepo.save(booking);

    }

    @Override
    public void deleteBooking(long idBooking) {
        bookingRepo.deleteById(idBooking);

    }
}
