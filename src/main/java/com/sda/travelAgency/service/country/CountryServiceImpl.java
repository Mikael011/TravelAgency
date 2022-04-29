package com.sda.travelAgency.service.country;

import com.sda.travelAgency.dto.airport.AirportFullDto;
import com.sda.travelAgency.dto.country.CountryCreateDto;
import com.sda.travelAgency.dto.country.CountryFullDto;
import com.sda.travelAgency.exception.CustomException;
import com.sda.travelAgency.mapper.CountryMapper;

import com.sda.travelAgency.model.Country;
import com.sda.travelAgency.repository.CountryRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public CountryFullDto create(CountryCreateDto countryCreateDto) {
        Country country = CountryMapper.countryToEntity(countryCreateDto);
        Country saveCountry = countryRepository.save(country);

        return CountryMapper.countryToFullDto(saveCountry);
    }

    @Override
    public CountryFullDto findCountryByNameAndId(String name, Integer id) {
        Country country = countryRepository.findByNameAndId(name, id).orElseThrow(() ->
                new CustomException("Country with name " + name + " and " + id + " not found!"));
        return CountryMapper.countryToFullDto(country);
    }

    @Override
    public void saveAllCountries(List<Country> listOfCountrys) {
        countryRepository.saveAll(listOfCountrys);
        System.out.println("All countries are created");
    }

    @Override
    public List<CountryFullDto> findAllCountries(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        List<CountryFullDto> returnList = new ArrayList<>();
        countryRepository.findAll(pageable).forEach(entity -> {
            returnList.add(CountryMapper.countryToFullDto(entity));
        });
        return returnList;
    }

    @Override
    public List<CountryFullDto> findAllCountries() {
        List<CountryFullDto> returnList = new ArrayList<>();
        countryRepository.findAll().forEach(entity -> {
            returnList.add(CountryMapper.countryToFullDto(entity));
        });

        return returnList;
    }
}
