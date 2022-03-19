package com.sda.travelAgency.controller.tour;

import com.sda.travelAgency.dto.reservation.ReservationCreateDto;
import com.sda.travelAgency.dto.reservation.ReservationFullDto;
import com.sda.travelAgency.dto.tour.TourCreateDto;
import com.sda.travelAgency.dto.tour.TourFullDto;
import com.sda.travelAgency.service.tour.TourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/tour")
@ControllerAdvice
public class TourController {

    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @PostMapping("/create")
    public ResponseEntity<TourFullDto> create(@RequestParam TourCreateDto tourCreateDto) {
        TourFullDto tourFullDto = tourService.create(tourCreateDto);

        return ResponseEntity.ok(tourFullDto);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TourFullDto>> findAllTours(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                          @RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
        List<TourFullDto> listOfTours = tourService.findAllTours(pageNumber, pageSize, sortBy);

        return ResponseEntity.ok(listOfTours);
    }
    @GetMapping("/findById")
    public ResponseEntity<TourFullDto> findById(@RequestParam Integer id) {
        TourFullDto tourFullDto = tourService.findTourById(id);

        return ResponseEntity.ok(tourFullDto);
    }
}
