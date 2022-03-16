package com.sda.travelAgency.mapper;

import com.sda.travelAgency.dto.reservation.ReservationCreateDto;
import com.sda.travelAgency.dto.reservation.ReservationFullDto;
import com.sda.travelAgency.model.Reservation;

public class ReservationMapper {

    public static Reservation reservationToEntity(ReservationCreateDto reservationCreateDto) {
        Reservation reservation = new Reservation();
        reservation.setRoomId(reservationCreateDto.getRoomId());

        return reservation;
    }

    public static ReservationFullDto reservationFullDto(Reservation reservation) {
        ReservationFullDto reservationFullDto = new ReservationFullDto();
        reservationFullDto.setId(reservation.getId());
        reservationFullDto.setRoomId(reservation.getRoomId());
        reservationFullDto.setUserId(reservation.getUserId());
        reservationFullDto.setStartDate(reservation.getStartDate());
        reservationFullDto.setEndDate(reservation.getEndDate());

        return reservationFullDto;
    }
}
