package com.sda.travelAgency.mapper;
import com.sda.travelAgency.dto.country.CountryCreateDto;
import com.sda.travelAgency.dto.country.CountryFullDto;
import com.sda.travelAgency.dto.ticket.TicketCreateDto;
import com.sda.travelAgency.dto.ticket.TicketFullDto;
import com.sda.travelAgency.model.Country;
import com.sda.travelAgency.model.Ticket;

public class TicketMapper {

    public static Ticket ticketToEntity(TicketCreateDto ticketCreateDto) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketCreateDto.getTicket().getId());
        return ticket;
    }

    public static TicketFullDto ticketFullDto(Ticket ticket){
        TicketFullDto ticketFullDto = new TicketFullDto();
        ticketFullDto.setId(ticket.getId());
        ticketFullDto.setTourId(ticket.getTour_id());
        ticketFullDto.setParticipants(ticket.getParticipants());
        ticketFullDto.setPrice(ticket.getPrice());
        return ticketFullDto;
    }

}
