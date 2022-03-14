package com.sda.travelAgency.controller.hotel;

import com.sda.travelAgency.dto.hotel.HotelFullDto;
import com.sda.travelAgency.service.hotel.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
@ControllerAdvice
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<HotelFullDto>> findAllHotels(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                             @RequestParam(defaultValue = "5") Integer pageSize,
                                                             @RequestParam(defaultValue = "id") String sortBy) {
        List<HotelFullDto> listOfHotels = hotelService.findAllHotels(pageNumber, pageSize, sortBy);
        return ResponseEntity.ok(listOfHotels);
    }
}

