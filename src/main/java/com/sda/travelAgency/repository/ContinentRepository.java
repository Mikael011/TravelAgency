package com.sda.travelAgency.repository;

import com.sda.travelAgency.model.Continent;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// TODO: 3/6/2022 Intrebare: trebuie extins interfata 'PagingAndSortingRepository'
@Repository
public interface ContinentRepository {

    Optional<Continent> findById(Integer id);

    Optional<Continent> findByName(String name);
}
