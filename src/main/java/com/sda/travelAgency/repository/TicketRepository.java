package com.sda.travelAgency.repository;

import com.sda.travelAgency.model.Ticket;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends PagingAndSortingRepository<Ticket, Integer> {

    // TODO: 3/14/2022 a fost o problema de nume de metoda, nu a mers aplicatia pana nu am redenumit din findByTicketId in findById
    Optional<Ticket> findById(Integer id);

}
