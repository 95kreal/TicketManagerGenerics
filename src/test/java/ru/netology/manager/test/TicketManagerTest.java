package ru.netology.manager.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {

    Ticket ticket1 = new Ticket(1, 4700, "LED", "VKO", 60);
    Ticket ticket2 = new Ticket(2, 6300, "IJK", "KRR", 180);
    Ticket ticket3 = new Ticket(3, 12050, "PEE", "SVX", 240);
    Ticket ticket4 = new Ticket(4, 3900, "TJM", "ROV", 360);
    Ticket ticket5 = new Ticket(5, 8400, "AAQ", "BAX", 120);
    Ticket ticket6 = new Ticket(6, 15000, "HMA", "BAX", 200);

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    @Test
    public void findAllBySort() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.findAllBySort("E", "V");
        Ticket[] expected = {ticket4, ticket1, ticket3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findEmptyRepository() {
        repo.add(ticket3);
        manager.add(ticket4);
        repo.removeById(3);
        repo.removeById(4);

        Ticket[] actual = manager.findAllBySort("E", "V");
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }
}