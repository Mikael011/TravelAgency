package com.sda.travelAgency.controller.country;

import com.sda.travelAgency.dto.country.CountryCreateDto;
import com.sda.travelAgency.dto.country.CountryFullDto;
import com.sda.travelAgency.service.country.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
@ControllerAdvice
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/create")
    public ResponseEntity<CountryFullDto> createCountry(@RequestBody CountryCreateDto countryCreateDto, Principal principal) {
//        System.out.println(principal.getName() + " has created a new country");//se poate decomenta dupa prima entitate creata in baza de tate

        CountryFullDto countryFullDto = countryService.create(countryCreateDto);
        return ResponseEntity.ok(countryFullDto);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<CountryFullDto>> findAllCountry(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                               @RequestParam(defaultValue = "5") Integer pageSize,
                                                               @RequestParam(defaultValue = "id") String sortBy) {
        List<CountryFullDto> listOfCountry = countryService.findAllCountries(pageNumber, pageSize, sortBy);
        return ResponseEntity.ok(listOfCountry);
    }
}
