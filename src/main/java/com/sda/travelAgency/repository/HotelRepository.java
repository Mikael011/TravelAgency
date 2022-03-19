package com.sda.travelAgency.repository;
import com.sda.travelAgency.model.Hotel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends PagingAndSortingRepository<Hotel, Integer> {

    Optional<Hotel> findById(Integer id);

    Optional<Hotel> findByName(String name);

}
