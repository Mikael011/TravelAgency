package com.sda.travelAgency.mapper;

import com.sda.travelAgency.dto.city.CityCreateDto;
import com.sda.travelAgency.dto.city.CityFullDto;
import com.sda.travelAgency.model.City;

public class CityMapper {

    public static City cityToEntity(CityCreateDto cityCreateDto) {
        City city = new City();
        city.setName(cityCreateDto.getName());

        return city;
    }

    public static CityFullDto cityFullDto(City city) {
        CityFullDto cityFullDto = new CityFullDto();
        city.setId(city.getId());
        cityFullDto.setName(city.getName());

        return cityFullDto;
    }
}
