package com.sda.travelAgency.mapper;

import com.sda.travelAgency.dto.ticket.TicketCreateDto;
import com.sda.travelAgency.dto.ticket.TicketFullDto;
import com.sda.travelAgency.model.Ticket;

public class TicketMapper {

    public static Ticket ticketToEntity(TicketCreateDto ticketCreateDto) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketCreateDto.getId());

        return ticket;
    }

    public static TicketFullDto ticketFullDto(Ticket ticket){
        TicketFullDto ticketFullDto = new TicketFullDto();
        ticketFullDto.setId(ticket.getId());
        ticketFullDto.setTourId(ticket.getTourId());
        ticketFullDto.setParticipants(ticket.getParticipants());
        ticketFullDto.setPrice(ticket.getPrice());

        return ticketFullDto;
    }

}
