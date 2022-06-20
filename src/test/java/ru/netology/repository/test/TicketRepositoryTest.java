package ru.netology.repository.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

public class TicketRepositoryTest {

    Ticket ticket1 = new Ticket(1, 4700, "LED", "VKO", 60);
    Ticket ticket2 = new Ticket(2, 6300, "IJK", "KRR", 180);
    Ticket ticket3 = new Ticket(3, 12050, "PEE", "SVX", 240);
    Ticket ticket4 = new Ticket(4, 3900, "TJM", "ROV", 360);
    Ticket ticket5 = new Ticket(5, 8400, "AAQ", "BAX", 120);
    Ticket ticket6 = new Ticket(6, 15000, "HMA", "BAX", 200);

    TicketRepository repo = new TicketRepository();

    @Test
    public void methodAdd() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById_FindByEmptyRepo() {
        repo.add(ticket3);
        repo.removeById(3);
        
        Ticket[] actual = repo.findAll();
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }
}
