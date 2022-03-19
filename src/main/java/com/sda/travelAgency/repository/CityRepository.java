package com.sda.travelAgency.repository;

import com.sda.travelAgency.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends PagingAndSortingRepository<City, Integer> {

    Optional<City> findById(Integer id);

    Optional<City> findByName(String name);

    Optional<City> findCityByCountryId( Integer countryId);

    City findCityById(Integer id);
}
