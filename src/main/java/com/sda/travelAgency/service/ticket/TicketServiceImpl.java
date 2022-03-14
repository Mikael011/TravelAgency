package com.sda.travelAgency.service.ticket;

import com.sda.travelAgency.dto.ticket.TicketFullDto;
import com.sda.travelAgency.exception.CustomException;
import com.sda.travelAgency.mapper.TicketMapper;
import com.sda.travelAgency.model.Ticket;
import com.sda.travelAgency.repository.TicketRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    @Override
    public TicketFullDto findTicketById(Integer id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() ->
                new CustomException("Ticket with" + id + " not found!"));
        return TicketMapper.ticketFullDto(ticket);
    }

    @Override
    public void saveAllTickets(List<Ticket> listOfTickets) {
        ticketRepository.saveAll(listOfTickets);
        System.out.println("All tickets are created");
    }

    @Override
    public List<TicketFullDto> findAllTickets(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        List<TicketFullDto> returnList = new ArrayList<>();
        ticketRepository.findAll(pageable).forEach(entity -> {
            returnList.add(TicketMapper.ticketFullDto(entity));
        });
        return returnList;
    }

    @Override
    public List<TicketFullDto> findAllTickets() {
        List<TicketFullDto> returnList = new ArrayList<>();
        ticketRepository.findAll().forEach(entity -> {
            returnList.add(TicketMapper.ticketFullDto(entity));
        });

        return returnList;
    }
}

