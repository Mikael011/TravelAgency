package com.sda.travelAgency.service.ticket;

import com.sda.travelAgency.dto.ticket.TicketFullDto;
import com.sda.travelAgency.model.Ticket;

import java.util.List;

public interface TicketService {
    TicketFullDto findTicketById(Integer id);

    void saveAllTickets(List<Ticket> listOfTickets);

    List<TicketFullDto> findAllTickets(Integer pageNumber, Integer pageSize, String sortBy);

    List<TicketFullDto> findAllTickets();

}
