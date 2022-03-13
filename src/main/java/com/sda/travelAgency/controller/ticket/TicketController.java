package com.sda.travelAgency.controller.ticket;

import com.sda.travelAgency.service.ticket.TicketService;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ticket")
@ControllerAdvice
public class TicketController {

    private final TicketService ticketService;


    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
