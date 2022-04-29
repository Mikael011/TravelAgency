package com.sda.travelAgency.repository;

import com.sda.travelAgency.model.Reservation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.geom.RectangularShape;
import java.util.Date;
import java.util.Optional;

@Repository
public interface ReservationRepository extends PagingAndSortingRepository<Reservation, Integer> {

    // private Integer id;
    //
    //    private String roomId;
    //
    //    private Integer userId;
    //
    //    private Date startDate;
    //
    //    private Date endDate;
    Optional<Reservation> findById(Integer id);

    Optional<Reservation> findByRoomId(String roomId);

    Optional<Reservation> findByUserId(Integer userId);

    Optional<Reservation> findByStartDate(Date startDate);

    Optional<Reservation> findByEndDate(Date endDate);



}
