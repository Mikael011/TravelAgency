package com.sda.travelAgency.mapper;

import com.sda.travelAgency.dto.airport.AirportCreateDto;
import com.sda.travelAgency.dto.airport.AirportFullDto;
import com.sda.travelAgency.dto.city.CityFullDto;
import com.sda.travelAgency.model.Airport;
import com.sda.travelAgency.model.City;

public class AirportMapper {

    public static Airport airportToEntity(AirportCreateDto airportCreateDto) {
        Airport airport = new Airport();
        airport.setName(airportCreateDto.getName());
        City city = new City();
        city.setId(airportCreateDto.getCityId());
        airport.setCity(city);
        return airport;
    }

    public static AirportFullDto airportToFullDto(Airport airport) {
        AirportFullDto airportFullDto = new AirportFullDto();
        airportFullDto.setId(airport.getId());
        airportFullDto.setName(airport.getName());
        CityFullDto cityDto = CityMapper.cityFullDto(airport.city);
        airportFullDto.setCity(cityDto);
        return airportFullDto;
    }
}
