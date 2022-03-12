package com.sda.travelAgency.controller.airport;

import com.sda.travelAgency.components.CustomFakerAirport;
import com.sda.travelAgency.dto.airport.AirportCreateDto;
import com.sda.travelAgency.dto.airport.AirportFullDto;
import com.sda.travelAgency.dto.airport.AirportResponseDto;
import com.sda.travelAgency.model.Airport;
import com.sda.travelAgency.service.AirportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/airport")
@ControllerAdvice
public class AirportController {

    private final AirportService airportService;

    private final CustomFakerAirport customFakerAirport;

    public AirportController(AirportService airportService, CustomFakerAirport customFakerAirport) {
        this.airportService = airportService;
        this.customFakerAirport = customFakerAirport;
    }

    @GetMapping("/generate")
    public void generateAirports() {

        List<Airport> listOfAirport = customFakerAirport.createDummyAirportList();


        airportService.saveAllAirports(listOfAirport);
    }

    @PostMapping("/create")
    public ResponseEntity<AirportResponseDto> createAirport(@RequestBody @Valid AirportCreateDto airportCreateDto, Principal principal) {
        System.out.println(principal.getName() + " has created a new airport.");
        AirportResponseDto airportResponseDto = airportService.create(airportCreateDto);

        return ResponseEntity.ok(airportResponseDto);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<AirportFullDto>> findAllAirport(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                               @RequestParam(defaultValue = "5") Integer pageSize,
                                                               @RequestParam(defaultValue = "id") String sortBy) {
        List<AirportFullDto> listOfAirport = airportService.findAllAirports(pageNumber, pageSize, sortBy);

        return ResponseEntity.ok(listOfAirport);
    }

    @GetMapping("/findByName")
    public ResponseEntity<AirportFullDto> findByName(@RequestParam String airportName) {
        AirportFullDto airportFullDto = airportService.findByName(airportName);

        return ResponseEntity.ok(airportFullDto);
    }

    public ResponseEntity<AirportFullDto> findById(@RequestParam Integer airportId) {
        AirportFullDto airportFullDto = airportService.findById(airportId);

        return ResponseEntity.ok(airportFullDto);
    }

    public ResponseEntity<AirportFullDto> findByNameAndId(@RequestParam String airportName,
                                                          @RequestParam Integer airportId) {
        AirportFullDto airportFullDto = airportService.findByNameAndId(airportName, airportId);

        return ResponseEntity.ok(airportFullDto);
    }
}
