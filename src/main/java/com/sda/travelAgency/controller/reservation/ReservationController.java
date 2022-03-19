package com.sda.travelAgency.controller.reservation;

import com.sda.travelAgency.dto.reservation.ReservationCreateDto;
import com.sda.travelAgency.dto.reservation.ReservationFullDto;
import com.sda.travelAgency.service.reservation.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservation")
@ControllerAdvice
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/create")
    public ResponseEntity<ReservationFullDto> create(@RequestParam ReservationCreateDto reservationCreateDto) {
        ReservationFullDto reservationFullDto = reservationService.create(reservationCreateDto);

        return ResponseEntity.ok(reservationFullDto);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ReservationFullDto>> findAllReservation(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                                       @RequestParam(defaultValue = "5") Integer pageSize,
                                                                       @RequestParam(defaultValue = "id") String sortBy) {
        List<ReservationFullDto> listOfReservation = reservationService.findAllReservations(pageNumber, pageSize, sortBy);

        return ResponseEntity.ok(listOfReservation);
    }

    @GetMapping("/findById")
    public ResponseEntity<ReservationFullDto> findById(@RequestParam Integer id) {
        ReservationFullDto reservationFullDto = reservationService.findReservationById(id);

        return ResponseEntity.ok(reservationFullDto);
    }
}
