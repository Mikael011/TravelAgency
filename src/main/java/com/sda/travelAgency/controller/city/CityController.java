package com.sda.travelAgency.controller.city;

import com.sda.travelAgency.dto.city.CityCreateDto;
import com.sda.travelAgency.dto.city.CityFullDto;
import com.sda.travelAgency.service.city.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/city")
@ControllerAdvice
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;

    }

    @PostMapping("/create")
    public ResponseEntity<CityFullDto> createCity(@RequestBody CityCreateDto cityCreateDto, Principal principal) {
//        System.out.println(principal.getName() + " has created a new city");//se poate decomenta dupa prima entitate creata in baza de tate

        CityFullDto cityFullDto = cityService.create(cityCreateDto);
        return ResponseEntity.ok(cityFullDto);
    }

    // http://localhost:8081/api/v1/city/findAll
    @GetMapping("/findAll")
    public ResponseEntity<List<CityFullDto>> findAllCities(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                              @RequestParam(defaultValue = "5") Integer pageSize,
                                                              @RequestParam(defaultValue = "id") String sortBy) {
        List<CityFullDto> listOfCity = cityService.findAllCities(pageNumber, pageSize, sortBy);
        return ResponseEntity.ok(listOfCity);
    }

    @GetMapping("/findByCountry")
    public ResponseEntity<CityFullDto> findByCity(@RequestParam String cityName) {
        CityFullDto cityFullDto = cityService.findCityByName(cityName);
        return ResponseEntity.ok(cityFullDto);
    }

}
