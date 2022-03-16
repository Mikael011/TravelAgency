package com.sda.travelAgency.service.reservation;

import com.sda.travelAgency.dto.reservation.ReservationFullDto;
import com.sda.travelAgency.exception.CustomException;
import com.sda.travelAgency.mapper.ReservationMapper;
import com.sda.travelAgency.model.Reservation;
import com.sda.travelAgency.repository.ReservationRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ReservationFullDto findReservationById(Integer id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() ->
                new CustomException("Reservation with id " + id + " not found!"));

        return ReservationMapper.reservationFullDto(reservation);
    }

    @Override
    public void saveAllReservations(List<Reservation> listOfReservations) {
        reservationRepository.saveAll(listOfReservations);
        System.out.println("All reservations are created");
    }

    @Override
    public List<ReservationFullDto> findAllReservations(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        List<ReservationFullDto> returnList = new ArrayList<>();
        reservationRepository.findAll(pageable).forEach(entity -> {
            returnList.add(ReservationMapper.reservationFullDto(entity));
        });
        return returnList;
    }

    @Override
    public List<ReservationFullDto> findAllReservations() {
        List<ReservationFullDto> returnList = new ArrayList<>();
        reservationRepository.findAll().forEach(entity -> {
            returnList.add(ReservationMapper.reservationFullDto(entity));
        });
        return returnList;
    }
}
