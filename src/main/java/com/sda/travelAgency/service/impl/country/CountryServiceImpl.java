package com.sda.travelAgency.service.impl.country;

import com.sda.travelAgency.dto.continent.ContinentFullDto;
import com.sda.travelAgency.dto.country.CountryCreateDto;
import com.sda.travelAgency.dto.country.CountryFullDto;
import com.sda.travelAgency.dto.country.CountryResponseDto;
import com.sda.travelAgency.exception.ContinentException;
import com.sda.travelAgency.exception.CountryException;
import com.sda.travelAgency.mapper.ContinentMapper;
import com.sda.travelAgency.mapper.CountryMapper;
import com.sda.travelAgency.model.Continent;
import com.sda.travelAgency.model.Country;
import com.sda.travelAgency.repository.CountryRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public CountryResponseDto create(CountryCreateDto countryCreateDto) {
        Country country = CountryMapper.countryToEntity(countryCreateDto);
        Country savedCountry = countryRepository.save(country);
        return CountryMapper.countryToResponseDto(savedCountry);
    }

    @Override
    public CountryFullDto findCountryByID(Integer id) {
        Country country = countryRepository.findById(id).orElseThrow(() ->
                new CountryException("Country with id " + id + " not found!"));
        return CountryMapper.countryToFullDto(country);
    }

    @Override
    public CountryFullDto findCountryByName(String name) {
        Country country = countryRepository.findByName(name).orElseThrow(() ->
                new CountryException("Country with name " + name + " not found!"));

        return CountryMapper.countryToFullDto(country);
    }

    @Override
    public CountryFullDto findCountryByNameAndId(String name, Integer id) {
        Country country = countryRepository.findByNameAndId(name, id).orElseThrow(() ->
                new CountryException("Country with name " + name + " and " + id + " not found!"));
        return CountryMapper.countryToFullDto(country);
    }

    @Override
    public void saveAllCountrys(List<Country> listOfCountrys) {
        countryRepository.saveAll(listOfCountrys);
        System.out.println("All countrys are created");
    }

    @Override
    public List<CountryFullDto> findAllCountrys(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        List<CountryFullDto> returnList = new ArrayList<>();
        countryRepository.findAll(pageable).forEach(entity -> {
            returnList.add(CountryMapper.countryToFullDto(entity));
        });
        return returnList;
    }

    @Override
    public List<CountryFullDto> findAllCountrys() {
        List<CountryFullDto> returnList = new ArrayList<>();
        countryRepository.findAll().forEach(entity -> {
            returnList.add(CountryMapper.countryToFullDto(entity));
        });

        return returnList;
    }
}
