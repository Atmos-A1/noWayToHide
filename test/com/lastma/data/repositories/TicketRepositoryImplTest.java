package com.lastma.data.repositories;

import com.lastma.data.models.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryImplTest {

    private TicketRepositoryImpl ticketRepository;
    private Ticket ticket;
    private Ticket ticketTwo;

    @BeforeEach
    public void setUp() {
        ticketRepository = new TicketRepositoryImpl();
        ticket = new Ticket();
        ticketTwo = new Ticket();
    }

    @Test
    public void testThatWhenISaveOneTicket_CountIsOne() {
        ticketRepository.save(ticket);
        assertEquals(1L, ticketRepository.count());
    }

    @Test
    public void testThatWhenIAddTwoTickets_CountIsTwo() {
        assertEquals(0L, ticketRepository.count());
        ticketRepository.save(ticket);
        ticketRepository.save(ticketTwo);
        assertEquals(2L, ticketRepository.count());
    }

    @Test
    public void testThatWhenISaveTicket_IDIsSet() {
        ticketRepository.save(ticket);
        assertEquals("1", ticket.getId());
    }

    @Test
    public void testThatSavedTicketsGetDifferentIDs() {
        ticketRepository.save(ticket);
        ticketRepository.save(ticketTwo);
        assertEquals("1", ticket.getId());
        assertEquals("2", ticketTwo.getId());
    }

    @Test
    public void testThatWhenIFindByID_TicketIsFound() {
        ticketRepository.save(ticket);
        assertEquals(ticket, ticketRepository.findByID(1));
    }

    @Test
    public void testThatFindByIDWithSecondTicket_ReturnsCorrectTicket() {
        ticketRepository.save(ticket);
        ticketRepository.save(ticketTwo);
        assertEquals(ticketTwo, ticketRepository.findByID(2));
    }

    @Test
    public void testThatFindByIDWithWrongID_ThrowsException() {
        ticketRepository.save(ticket);
        assertThrows(IllegalArgumentException.class, () -> ticketRepository.findByID(99));
    }
}