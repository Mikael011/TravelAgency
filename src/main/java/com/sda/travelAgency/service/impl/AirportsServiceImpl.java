package com.sda.travelAgency.service.impl;

import com.sda.travelAgency.dto.airport.AirportCreateDto;
import com.sda.travelAgency.dto.airport.AirportFullDto;
import com.sda.travelAgency.dto.airport.AirportResponseDto;
import com.sda.travelAgency.exception.CustomException;
import com.sda.travelAgency.mapper.AirportMapper;
import com.sda.travelAgency.mapper.ContinentMapper;
import com.sda.travelAgency.model.Airport;
import com.sda.travelAgency.repository.AirportRepository;
import com.sda.travelAgency.service.AirportService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.xml.catalog.CatalogManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class AirportsServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    public AirportsServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public AirportResponseDto create(AirportCreateDto airportCreateDto) {
        Airport airport = AirportMapper.airportToEntity(airportCreateDto);
        Airport savedAirport = airportRepository.save(airport);

        return AirportMapper.airportToResponseDto(savedAirport);
    }

    @Override
    public AirportFullDto findById(Integer id) {
        Airport airport = airportRepository.findById(id).orElseThrow(() ->
                new CustomException("Airport with id " + id + " not found!"));

        return  AirportMapper.airportToFullDto(airport);
    }

    @Override
    public AirportFullDto findByName(String name) {
        Airport airport = airportRepository.findByName(name).orElseThrow(() ->
                new CustomException("Airport with name " + name + " not found!" ));
        return AirportMapper.airportToFullDto(airport);
    }

    @Override
    public AirportFullDto findByNameAndId(String name, Integer id) {
        Airport airport = airportRepository.findByNameAndId(name, id).orElseThrow(() ->
                new CustomException("Airport with name " + name + " and " + id + " not found!"));
        return AirportMapper.airportToFullDto(airport);
    }

    @Override
    public void saveAllAirports(List<Airport> listOfAirports) {
        airportRepository.saveAll(listOfAirports);
        System.out.println("All airports are created.");
    }

    @Override
    public List<AirportFullDto> findAllAirports(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        List<AirportFullDto> returnList = new ArrayList<>();
        airportRepository.findAll(pageable).forEach(entity -> {
            returnList.add(AirportMapper.airportToFullDto(entity));
        });
        return returnList;
    }

    @Override
    public List<AirportFullDto> findAllAirports() {
        List<AirportFullDto> returnList = new ArrayList<>();
        airportRepository.findAll().forEach(entity -> {
            returnList.add(AirportMapper.airportToFullDto(entity));
        });
        return returnList;
    }

}