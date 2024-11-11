package com.esprit.microservice.gestionvols.services;

import com.esprit.microservice.gestionvols.entites.Ticket;
import com.esprit.microservice.gestionvols.repositories.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements ITicketService{

    @Autowired
    TicketRepo ticketRepo;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }

    @Override
    public Optional getTicketById(long idTicket) {
        return ticketRepo.findById(idTicket);
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepo.save(ticket);

    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepo.save(ticket);

    }

    @Override
    public void deleteTicket(long idTicket) {
        ticketRepo.deleteById(idTicket);

    }
}
