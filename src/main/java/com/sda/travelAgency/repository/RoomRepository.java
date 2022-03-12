package com.sda.travelAgency.repository;

import com.sda.travelAgency.model.Room;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends PagingAndSortingRepository {

    Optional<Room> findByNumber(Integer number);

    Optional<Room> findByCapacity(Integer capacity);
}
