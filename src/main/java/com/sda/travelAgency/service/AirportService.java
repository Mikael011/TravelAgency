package com.sda.travelAgency.service;

import com.sda.travelAgency.dto.airport.AirportCreateDto;
import com.sda.travelAgency.dto.airport.AirportFullDto;
import com.sda.travelAgency.dto.airport.AirportResponseDto;
import com.sda.travelAgency.model.Airport;

import java.util.List;

public interface AirportService {
    AirportResponseDto create(AirportCreateDto airportCreateDto);

    AirportFullDto findById(Integer id);

    AirportFullDto findByName(String name);

    AirportFullDto findByNameAndId(String name, Integer id);

    void saveAllAirports(List<Airport> listOfAirports);

    List<AirportFullDto> findAllAirports(Integer pageNumber, Integer pageSize, String sortBy);

    List<AirportFullDto> findAllAirports();
}
