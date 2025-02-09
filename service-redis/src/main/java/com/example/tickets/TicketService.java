package com.example.tickets;

import com.example.annotations.RedissonLock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TicketService {
    private final String TICKET_KEY = "#ticketId-5a67de67-6f81-4921-b301-ca4109211fa1";

    private final TicketRepository ticketRepository;

    public void ticketing(Long ticketId, Long quantity){
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
        ticket.decrease(quantity);
        log.info("quantity: {}, after quantity: {}", quantity, ticket.getQuantity());
        ticketRepository.saveAndFlush(ticket);
    }

    public void normalTicketing(Long ticketId, Long quantity){
        ticketing(ticketId, quantity);
    }

    @RedissonLock(value = TICKET_KEY)
    public void redissonTicketing(Long ticketId, Long quantity){
        ticketing(ticketId, quantity);
    }
}
