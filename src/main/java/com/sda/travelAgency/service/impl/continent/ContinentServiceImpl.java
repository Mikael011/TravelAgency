package com.sda.travelAgency.service.impl.continent;

import com.sda.travelAgency.dto.continent.ContinentCreateDto;
import com.sda.travelAgency.dto.continent.ContinentFullDto;
import com.sda.travelAgency.dto.continent.ContinentResponseDto;

import com.sda.travelAgency.exception.CustomException;

import com.sda.travelAgency.mapper.ContinentMapper;
import com.sda.travelAgency.model.Continent;
import com.sda.travelAgency.repository.ContinentRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContinentServiceImpl implements ContinentService {

    private final ContinentRepository continentRepository;

    public ContinentServiceImpl(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    @Override
    public ContinentResponseDto create(ContinentCreateDto continentCreateDto) {
        Continent continent = ContinentMapper.continentToEntity(continentCreateDto);
        Continent savedContinent = continentRepository.save(continent);

        return ContinentMapper.continentToResponseDto(savedContinent);
    }

    @Override
    public ContinentFullDto findContinentById(Integer id) {// SonarList disabled for this method
        Continent continent = continentRepository.findById(id).orElseThrow(() ->
                new CustomException("Continent with id " + id + " not found!"));

        return ContinentMapper.continentToFullDto(continent);
    }

    // SonarList disabled for this method
    @Override
    public ContinentFullDto findContinentByName(String name) {
        Continent continent = continentRepository.findByName(name).orElseThrow(() ->
                new CustomException("Continent with name " + name +" not found!"));

        return ContinentMapper.continentToFullDto(continent);
    }

    @Override
    public ContinentFullDto findContinentByNameAndId(String name, Integer id) {
        Continent continent = continentRepository.findByNameAndId(name, id).orElseThrow(() ->
                new CustomException("Continent with name " + name + " and " + id + " not found!"));

        return ContinentMapper.continentToFullDto(continent);
    }

    @Override
    public void saveAllContinents(List<Continent> listOfContinents) {
        continentRepository.saveAll(listOfContinents);
        System.out.println("All continents are created.");

    }

    @Override
    public List<ContinentFullDto> findAllContinents(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        List<ContinentFullDto> returnList = new ArrayList<>();
        continentRepository.findAll(pageable).forEach(entity -> {
            returnList.add(ContinentMapper.continentToFullDto(entity));
        });

        return returnList;
    }

    @Override
    public List<ContinentFullDto> findAllContinents() {
        List<ContinentFullDto> returnList = new ArrayList<>();
        continentRepository.findAll().forEach(entity -> {
            returnList.add(ContinentMapper.continentToFullDto(entity));
        });

        return returnList;
    }
}
