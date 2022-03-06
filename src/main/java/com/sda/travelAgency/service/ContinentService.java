package com.sda.travelAgency.service;

import com.sda.travelAgency.dto.ContinentCreateDto;
import com.sda.travelAgency.dto.ContinentFullDto;
import com.sda.travelAgency.dto.ContinentResponseDto;
import com.sda.travelAgency.model.Continent;

import java.util.List;

public interface ContinentService {

    ContinentResponseDto create(ContinentCreateDto continentCreateDto);

    ContinentFullDto findContinentById(Integer id);

    ContinentFullDto findContinentByName(String name);

    void saveAllContinents(List<Continent> listOfContinents);

    List<ContinentFullDto> findAll(Integer pageNumber, Integer pageSize, String sortBy);

    List<ContinentFullDto> findAll();
}
