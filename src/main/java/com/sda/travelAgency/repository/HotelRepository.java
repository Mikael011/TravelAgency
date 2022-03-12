package com.sda.travelAgency.repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.Optional;

public interface HotelRepository extends PagingAndSortingRepository {

    Optional<HotelRepository> findById(Integer id);

    Optional<HotelRepository> findByName(String name);

}
