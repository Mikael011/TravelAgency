package com.sda.travelAgency.controller.airport;

import com.sda.travelAgency.dto.airport.AirportFullDto;
import com.sda.travelAgency.service.airport.AirportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/airport")
@ControllerAdvice
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<AirportFullDto>> findAllAirport(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                               @RequestParam(defaultValue = "5") Integer pageSize,
                                                               @RequestParam(defaultValue = "id") String sortBy) {
        List<AirportFullDto> listOfAirport = airportService.findAllAirports(pageNumber, pageSize, sortBy);

        return ResponseEntity.ok(listOfAirport);
    }

    @GetMapping("/findByCityID")
    public ResponseEntity<AirportFullDto> findByCityID(@RequestParam Integer airportCityId) {
        AirportFullDto airportFullDto = airportService.findByCityId(airportCityId);

        return ResponseEntity.ok(airportFullDto);
    }

}
