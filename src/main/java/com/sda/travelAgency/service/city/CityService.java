package com.sda.travelAgency.service.city;

import com.sda.travelAgency.dto.city.CityFullDto;

import java.util.List;

public interface CityService {

    CityFullDto findCityByName(String name);

    List<CityFullDto> findAllCities(Integer pageNumber, Integer pageSize, String sortBy);

    List<CityFullDto> findAllCities();

}
