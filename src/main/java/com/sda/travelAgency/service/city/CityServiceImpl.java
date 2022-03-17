package com.sda.travelAgency.service.city;

import com.sda.travelAgency.dto.city.CityCreateDto;
import com.sda.travelAgency.dto.city.CityFullDto;
import com.sda.travelAgency.exception.CustomException;
import com.sda.travelAgency.mapper.CityMapper;
import com.sda.travelAgency.model.City;
import com.sda.travelAgency.repository.CityRepository;
import com.sda.travelAgency.service.city.CityService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository continentRepository) {
        this.cityRepository = continentRepository;
    }

    @Override
    public CityFullDto create(CityCreateDto cityCreateDto) {
        City city = CityMapper.cityToEntity(cityCreateDto);
        City savedCity = cityRepository.save(city);

        return CityMapper.cityFullDto(savedCity);
    }

    // SonarList disabled for this method
    @Override
    public CityFullDto findCityByName(String name) {
        City city = cityRepository.findByName(name).orElseThrow(() ->
                new CustomException("Continent with name " + name +" not found!"));

        return CityMapper.cityFullDto(city);
    }

    @Override
    public List<CityFullDto> findAllCities(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        List<CityFullDto> returnList = new ArrayList<>();
        cityRepository.findAll(pageable).forEach(entity -> {
            returnList.add(CityMapper.cityFullDto(entity));
        });

        return returnList;
    }

    @Override
    public List<CityFullDto> findAllCities() {
        List<CityFullDto> returnList = new ArrayList<>();
        cityRepository.findAll().forEach(entity -> {
            returnList.add(CityMapper.cityFullDto(entity));
        });

        return returnList;
    }
}
