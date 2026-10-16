package com.lastma.data.repositories;

import com.lastma.data.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {

    private List<Ticket> tickets = new ArrayList<>();
    private int numberOfTickets;

    @Override
    public Ticket save(Ticket ticket) {
        ticket.setId(String.valueOf(++numberOfTickets));
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public long count() {
        return numberOfTickets;
    }

    @Override
    public Ticket findByID(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId().equals(String.valueOf(id))) {
                return ticket;
            }
        }
        throw new IllegalArgumentException("Ticket with id " + id + " not found");
    }
}