package com.sda.travelAgency.repository;

import com.sda.travelAgency.model.Continent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContinentRepository extends PagingAndSortingRepository<Continent, Integer> {

    Optional<Continent> findById(Integer id);

    Optional<Continent> findByName(String name);

    Optional<Continent> findByNameAndId(String name, Integer id);
}
