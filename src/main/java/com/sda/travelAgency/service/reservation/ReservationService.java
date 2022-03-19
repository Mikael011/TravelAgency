package com.sda.travelAgency.service.reservation;

import com.sda.travelAgency.dto.reservation.ReservationCreateDto;
import com.sda.travelAgency.dto.reservation.ReservationFullDto;
import com.sda.travelAgency.model.Reservation;
import java.util.List;

public interface ReservationService {

    ReservationFullDto create(ReservationCreateDto reservationCreateDto);

    ReservationFullDto findReservationById(Integer id);

    void saveAllReservations(List<Reservation> listOfReservations);

    List<ReservationFullDto> findAllReservations(Integer pageNumber, Integer pageSize, String sortBy);

    List<ReservationFullDto> findAllReservations();
}
