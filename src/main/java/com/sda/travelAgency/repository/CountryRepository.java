package com.sda.travelAgency.repository;

import com.sda.travelAgency.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CountryRepository extends PagingAndSortingRepository<Country, Integer> {

    Optional<Country> findById(Integer id);
    Optional<Country> findByName(String name);

    Optional<Country> findByNameAndId(String name, Integer id);
}
