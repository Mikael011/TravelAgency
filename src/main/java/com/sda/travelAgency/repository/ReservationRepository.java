package com.sda.travelAgency.repository;

import com.sda.travelAgency.model.Reservation;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ReservationRepository extends PagingAndSortingRepository<Reservation, Integer> {

    Optional<Reservation> findById(Integer id);

}
