package com.sda.travelAgency.service.country;

import com.sda.travelAgency.dto.airport.AirportFullDto;
import com.sda.travelAgency.dto.country.CountryCreateDto;
import com.sda.travelAgency.dto.country.CountryFullDto;
import com.sda.travelAgency.model.Country;

import java.util.List;

public interface CountryService {

    CountryFullDto create(CountryCreateDto countryCreateDto);

    CountryFullDto findCountryByNameAndId(String name, Integer id);

    void saveAllCountries(List<Country> listOfCountrys);

    List<CountryFullDto> findAllCountries(Integer pageNumber, Integer pageSize, String sortBy);

    List<CountryFullDto> findAllCountries();
}
