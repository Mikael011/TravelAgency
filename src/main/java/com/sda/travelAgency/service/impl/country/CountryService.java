package com.sda.travelAgency.service.impl.country;

import com.sda.travelAgency.dto.continent.ContinentFullDto;
import com.sda.travelAgency.dto.country.CountryCreateDto;
import com.sda.travelAgency.dto.country.CountryFullDto;
import com.sda.travelAgency.dto.country.CountryResponseDto;
import com.sda.travelAgency.model.Continent;
import com.sda.travelAgency.model.Country;

import java.util.List;

public interface CountryService {
    CountryResponseDto create(CountryCreateDto countryCreateDto);

    CountryFullDto findCountryByID(Integer id);

    CountryFullDto findCountryByName(String name);

    CountryFullDto findCountryByNameAndId(String name, Integer id);

    void saveAllCountrys(List<Country> listOfCountrys);

    List<CountryFullDto> findAllCountrys(Integer pageNumber, Integer pageSize, String sortBy);

    List<CountryFullDto> findAllCountrys();


}
