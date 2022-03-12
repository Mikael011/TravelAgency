package com.sda.travelAgency.service.country;

import com.sda.travelAgency.dto.country.CountryCreateDto;
import com.sda.travelAgency.dto.country.CountryFullDto;
import com.sda.travelAgency.model.Country;

import java.util.List;

public interface CountryService {

    CountryFullDto findCountryByNameAndId(String name, Integer id);

    void saveAllCountrys(List<Country> listOfCountrys);

    List<CountryFullDto> findAllCountrys(Integer pageNumber, Integer pageSize, String sortBy);

    List<CountryFullDto> findAllCountrys();


}
