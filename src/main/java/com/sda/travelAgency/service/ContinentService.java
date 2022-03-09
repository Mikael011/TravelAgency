package com.sda.travelAgency.service;

import com.sda.travelAgency.dto.continent.ContinentCreateDto;
import com.sda.travelAgency.dto.continent.ContinentFullDto;
import com.sda.travelAgency.dto.continent.ContinentResponseDto;
import com.sda.travelAgency.model.Continent;

import java.util.List;

public interface ContinentService {

    ContinentResponseDto create(ContinentCreateDto continentCreateDto);

    ContinentFullDto findContinentById(Integer id);

    ContinentFullDto findContinentByName(String name);

    ContinentFullDto findContinentByNameAndId(String name, Integer id);

    void saveAllContinents(List<Continent> listOfContinents);

    List<ContinentFullDto> findAllContinents(Integer pageNumber, Integer pageSize, String sortBy);

    List<ContinentFullDto> findAllContinents();

}
