package com.sda.travelAgency.repository;

import com.sda.travelAgency.model.Tour;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> {

    Optional<Tour> findById(Integer id);
}
