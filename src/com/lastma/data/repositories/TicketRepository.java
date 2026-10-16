package com.lastma.data.repositories;

import com.lastma.data.models.Ticket;

public interface TicketRepository {

    Ticket save(Ticket ticket);

    long count();

    Ticket findByID(int id);
}
