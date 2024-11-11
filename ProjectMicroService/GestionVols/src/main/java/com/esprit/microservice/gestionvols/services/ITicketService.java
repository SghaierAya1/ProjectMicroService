package com.esprit.microservice.gestionvols.services;

import com.esprit.microservice.gestionvols.entites.Ticket;

import java.util.List;
import java.util.Optional;

public interface ITicketService {
    List<Ticket> getAllTickets();
    Optional getTicketById(long idTicket);
    Ticket saveTicket(Ticket ticket);
    Ticket updateTicket(Ticket ticket);
    void deleteTicket(long idTicket);
}
