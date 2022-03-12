package com.sda.travelAgency.repository;
import com.sda.travelAgency.model.Ticket;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends PagingAndSortingRepository<Ticket, Integer> {

    Optional<Ticket> findByTicketId(Integer id);

}
