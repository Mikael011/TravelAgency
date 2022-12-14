package com.sda.travelAgency.repository;

import com.sda.travelAgency.dto.airport.AirportFullDto;
import com.sda.travelAgency.model.Airport;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends PagingAndSortingRepository<Airport, Integer> {

    Optional<Airport> findByCityId(Integer id);
    List<Airport> findByCity_NameStartingWith(String searchString);
    List<Airport> findByCity_Country_NameStartingWith(String searchString);


}
