package com.sda.travelAgency.service.airport;

import com.sda.travelAgency.dto.airport.AirportCreateDto;
import com.sda.travelAgency.dto.airport.AirportFullDto;
import com.sda.travelAgency.model.Airport;

import java.util.List;

public interface AirportService {

    AirportFullDto findByCityId(Integer id);


    void saveAllAirports(List<Airport> listOfAirports);

    List<AirportFullDto> findAllAirports(Integer pageNumber, Integer pageSize, String sortBy);

    List<AirportFullDto> findAllAirports();
}