package com.sda.travelAgency.controller.ticket;

import com.sda.travelAgency.dto.ticket.TicketFullDto;
import com.sda.travelAgency.service.ticket.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticket")
@ControllerAdvice
public class TicketController {

    private final TicketService ticketService;


    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/findTicketById")
    public ResponseEntity<TicketFullDto> findTicketById(@RequestParam Integer ticketId) {
        TicketFullDto ticketFullDto = ticketService.findTicketById(ticketId);

        return ResponseEntity.ok(ticketFullDto);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TicketFullDto>> findAllTickets(@RequestParam(defaultValue = "0") Integer number,
                                                              @RequestParam(defaultValue = "5") Integer allTickets,
                                                              @RequestParam(defaultValue = "id") String sortBy) {
        List<TicketFullDto> listOfTicket = ticketService.findAllTickets(number, allTickets, sortBy);

        return ResponseEntity.ok(listOfTicket);
    }


}
