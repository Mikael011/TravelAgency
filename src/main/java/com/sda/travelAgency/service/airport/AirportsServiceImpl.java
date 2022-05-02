package com.sda.travelAgency.service.airport;

import com.sda.travelAgency.dto.airport.AirportCreateDto;
import com.sda.travelAgency.dto.airport.AirportFullDto;
import com.sda.travelAgency.exception.CustomException;
import com.sda.travelAgency.mapper.AirportMapper;
import com.sda.travelAgency.mapper.CityMapper;
import com.sda.travelAgency.model.Airport;
import com.sda.travelAgency.model.City;
import com.sda.travelAgency.repository.AirportRepository;
import com.sda.travelAgency.repository.CityRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportsServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final CityRepository cityRepository;

    public AirportsServiceImpl(AirportRepository airportRepository, CityRepository cityRepository) {
        this.airportRepository = airportRepository;
        this.cityRepository = cityRepository;
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
    public AirportFullDto findByCityId(Integer id) {
        Airport airport = airportRepository.findByCityId(id).orElseThrow(() ->
                new CustomException("Airport with id " + id + " not found!"));

        return AirportMapper.airportToFullDto(airport);
    }

    @Override
    public AirportFullDto create(AirportCreateDto airportCreateDto) {
        Airport airport = AirportMapper.airportToEntity(airportCreateDto);
        Airport savedAirport = airportRepository.save(airport);

        return AirportMapper.airportToFullDto(savedAirport);
    }

    @Override
    public void saveAllAirports(List<Airport> listOfAirports) {
        airportRepository.saveAll(listOfAirports);
        System.out.println("All airports are created.");
    }

    @Override
    public List<AirportFullDto> findAllAirports() {
        List<AirportFullDto> returnList = new ArrayList<>();
        airportRepository.findAll().forEach(entity -> {
            returnList.add(AirportMapper.airportToFullDto(entity));
        });
        return returnList;
    }

    @Override
    public void addAirportsToCity(Integer airportId, Integer cityId) {
        City city = cityRepository.findCityById(cityId);
        Airport airport = airportRepository.findById(airportId).get();
        airport.setCity(city);
        airportRepository.save(airport);
    }

    @Override
    public List<AirportFullDto> getAirportsByCountry(Integer countryId) {
        List<Airport> airports = (List<Airport>) airportRepository.findAll();
        List<AirportFullDto> returnList = new ArrayList<>();

        airports.forEach(x -> {
            if (x.city.country.getId() == countryId) {
                AirportFullDto adto = AirportMapper.airportToFullDto(x);
                returnList.add(adto);
            }
        });

        return returnList;
    }

    @Override
    public List<AirportFullDto> getAirportsByText(String searchString) {
        List<AirportFullDto> returnList = new ArrayList<>();
        List<Airport> cityResultList = airportRepository.findByCity_NameStartingWith(searchString);
        List<Airport> countryResultList = airportRepository.findByCity_Country_NameStartingWith(searchString);

        cityResultList.forEach(x -> {
            AirportFullDto adto = AirportMapper.airportToFullDto(x);
            returnList.add(adto);
        });
        countryResultList.forEach(x -> {
            AirportFullDto adto = AirportMapper.airportToFullDto(x);
            returnList.add(adto);
        });
        return returnList;
    }
}
