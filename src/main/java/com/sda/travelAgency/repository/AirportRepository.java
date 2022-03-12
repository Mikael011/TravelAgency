package com.sda.travelAgency.repository;

import com.sda.travelAgency.model.Airport;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportRepository extends PagingAndSortingRepository<Airport, Integer> {

    Optional<Airport> findById(Integer id);

    Optional<Airport> findByName(String name);

    Optional<Airport> findByNameAndId(String name, Integer id);

}
