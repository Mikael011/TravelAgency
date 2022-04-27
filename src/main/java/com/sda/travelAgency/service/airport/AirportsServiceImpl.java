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
    public AirportFullDto create(AirportCreateDto airportCreateDto) {
        Airport airport= AirportMapper.airportToEntity(airportCreateDto);
        Airport savedAirport = airportRepository.save(airport);

        return AirportMapper.airportToFullDto(savedAirport);
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

    @Override
    public void addAirportsToCity(Integer airportId, Integer cityId) {
        City city = cityRepository.findCityById(cityId);
        AirportFullDto airportFullDto = new AirportFullDto();
        airportFullDto.setCity(city);
    }

    @Override
    public AirportFullDto findByCityId(Integer id) {
        Airport airport = airportRepository.findByCityId(id).orElseThrow(() ->
                new CustomException("Airport with id " + id + " not found!"));

        return  AirportMapper.airportToFullDto(airport);
    }

    @Override
    public List<AirportFullDto> getAirportsByCountry(Integer countryId) {
        List<Airport> airports =  (List<Airport>) airportRepository.findAll();
        List<AirportFullDto> returnList = new ArrayList<>();

        airports.forEach(x -> {
            if(x.city.country.getId() == countryId) {
                returnList.add(AirportMapper.airportToFullDto(x));
            }
        });

        return returnList;
    }

//    @Override
//    public List<AirportFullDto> getAirportsByCountry(String country) {
//        List<AirportFullDto> returnList = new ArrayList<>();
//        cityRepository.findAll().forEach(entity -> {
//            returnList.add(CityMapper.cityFullDto(entity));
//        });
//return returnList;
//    }
}
