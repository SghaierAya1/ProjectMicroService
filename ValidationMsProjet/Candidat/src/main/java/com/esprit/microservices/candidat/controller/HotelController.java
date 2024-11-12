package com.esprit.microservices.candidat.controller;
import com.esprit.microservices.candidat.entities.Hotel;
import com.esprit.microservices.candidat.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api   ")
public class HotelController {


    @Autowired
    private HotelService hotelService ;

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Hotel> createCandidat(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.addHotel (hotel), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Hotel> updateCandidat(@PathVariable(value = "id") int id,
                                                   @RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.updateHotel (id, hotel),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(hotelService.deleteHotel (id), HttpStatus.OK);
    }
}
