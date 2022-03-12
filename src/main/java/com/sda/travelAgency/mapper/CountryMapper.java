package com.sda.travelAgency.mapper;

import com.sda.travelAgency.dto.country.CountryCreateDto;
import com.sda.travelAgency.dto.country.CountryFullDto;
import com.sda.travelAgency.model.Country;

public class CountryMapper {

    public static Country countryToEntity(CountryCreateDto countryCreateDto) {
        Country country = new Country();
        country.setName(countryCreateDto.getName());
        return country;
    }

    public static CountryFullDto countryToFullDto(Country country) {
        CountryFullDto countryFullDto = new CountryFullDto();
        countryFullDto.setId(country.getId());
        countryFullDto.setName(country.getName());
        countryFullDto.setCity(country.getCity());
        return countryFullDto;
    }

}
