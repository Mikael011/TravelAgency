package com.sda.travelAgency.mapper;

import com.sda.travelAgency.dto.airport.AirportCreateDto;
import com.sda.travelAgency.dto.airport.AirportFullDto;
import com.sda.travelAgency.dto.airport.AirportResponseDto;
import com.sda.travelAgency.model.Airport;

public class AirportMapper {

    public static Airport airportToEntity(AirportCreateDto airportCreateDto) {
        Airport airport = new Airport();
        airport.setName(airportCreateDto.getName());

        return airport;
    }

    public static AirportResponseDto airportToResponseDto(Airport airport) {
        AirportResponseDto airportResponseDto = new AirportResponseDto();
        airportResponseDto.setId(airport.getId());
        airportResponseDto.setName(airport.getName());
        airportResponseDto.setCityId(airport.getCityId());

        return airportResponseDto;
    }

    public static AirportFullDto airportToFullDto(Airport airport) {
        AirportFullDto airportFullDto = new AirportFullDto();
        airportFullDto.setId(airport.getId());
        airportFullDto.setName(airport.getName());
        airportFullDto.setCityId(airport.getCityId());

        return airportFullDto;
    }
}
