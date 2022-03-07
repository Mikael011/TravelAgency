package com.sda.travelAgency.mapper;

import com.sda.travelAgency.dto.ContinentCreateDto;
import com.sda.travelAgency.dto.ContinentFullDto;
import com.sda.travelAgency.dto.ContinentResponseDto;
import com.sda.travelAgency.model.Continent;

public class ContinentMapper {

    public static Continent continentToEntity(ContinentCreateDto continentCreateDto) {
        Continent continent = new Continent();
        continent.setName(continentCreateDto.getName());

        return continent;
    }

    public static ContinentResponseDto continentToResponseDto(Continent continent) {
        ContinentResponseDto continentResponseDto = new ContinentResponseDto();
        continentResponseDto.setId(continent.getId());
        continentResponseDto.setName(continent.getName());

        return continentResponseDto;
    }

    public static ContinentFullDto continentToFullDto(Continent continent) {
        ContinentFullDto continentFullDto = new ContinentFullDto();
        continentFullDto.setId(continent.getId());
        continentFullDto.setName(continent.getName());

        return continentFullDto;
    }
}
