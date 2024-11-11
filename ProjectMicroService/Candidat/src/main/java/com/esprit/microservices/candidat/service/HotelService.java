package com.esprit.microservices.candidat.service;

import com.esprit.microservices.candidat.entities.Hotel;
import com.esprit.microservices.candidat.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;







@Service
public class HotelService {
    @Autowired
    private HotelRepo hotelRepo;

    public Hotel addHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }
    public Hotel updateHotel(int id, Hotel newHotel) {
        if (hotelRepo.findById(id).isPresent()) {
            Hotel existingHotel = hotelRepo.findById(id).get();
            existingHotel.setNom(newHotel.getNom());
            existingHotel.setAdresse(newHotel.getAdresse());
            existingHotel.setCategorie(newHotel.getCategorie());
            existingHotel.setTypeDeChambre(newHotel.getTypeDeChambre());
            existingHotel.setDateDisponibleDebut(newHotel.getDateDisponibleDebut());
            existingHotel.setDateDisponibleFin(newHotel.getDateDisponibleFin());
            existingHotel.setPrixParNuit(newHotel.getPrixParNuit());

            return hotelRepo.save(existingHotel);
        } else
            return null;
    }
    public String deleteHotel(int id) {
        if (hotelRepo.findById(id).isPresent()) {
            hotelRepo.deleteById(id);
            return "hotel supprimé";
        } else
            return "hotel non supprimé";
    }
}
