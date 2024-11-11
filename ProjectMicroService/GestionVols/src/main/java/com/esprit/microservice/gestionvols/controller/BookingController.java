package com.esprit.microservice.gestionvols.controller;
import com.esprit.microservice.gestionvols.entites.Booking;
import com.esprit.microservice.gestionvols.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;


    @PostMapping("/reserve")
    public ResponseEntity<Booking> reserveFlight(@RequestParam Long passengerId,
                                                 @RequestParam Long flightId) {
        try {
            // Create the booking using passengerId and flightId
            Booking booking = bookingService.createBooking(passengerId, flightId);
            return ResponseEntity.status(HttpStatus.CREATED).body(booking);
        } catch (RuntimeException ex) {
            // Handle cases where passenger or flight is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long idBooking) {
        Optional<Booking> booking = bookingService.getBookingById(idBooking);
        return booking.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return    bookingService.saveBooking(booking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        if (!bookingService.getBookingById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        booking.setIdBooking(id);
        Booking updatedBooking = bookingService.updateBooking(booking);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        if (!bookingService.getBookingById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
