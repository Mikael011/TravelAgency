package com.sda.travelAgency.controller;


import com.sda.travelAgency.components.CustomFakerCountry;
import com.sda.travelAgency.dto.continent.ContinentCreateDto;

import com.sda.travelAgency.dto.continent.ContinentResponseDto;
import com.sda.travelAgency.dto.country.CountryCreateDto;
import com.sda.travelAgency.dto.country.CountryFullDto;
import com.sda.travelAgency.dto.country.CountryResponseDto;
import com.sda.travelAgency.model.Continent;
import com.sda.travelAgency.model.Country;
import com.sda.travelAgency.service.impl.country.CountryService;
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

    private final CustomFakerCountry customFakerCountry;

/*
CountryService countryService -> nu a functionat initial -> am creat in AppConfig si am implementat metodele -> nu sunt sigur ca ii corect

 */
    public CountryController(CountryService countryService, CustomFakerCountry customFakerCountry) {
        this.countryService = countryService;
        this.customFakerCountry = customFakerCountry;
    }
    @GetMapping("/generate")
    public void generateCountry() {
        List<Country> listOfCountry = customFakerCountry.createDummyCountryList();
        countryService.saveAllCountrys(listOfCountry);
    }

    @PostMapping("/create")
    public ResponseEntity<CountryResponseDto> createCountry(@RequestBody @Valid CountryCreateDto countryCreateDto, Principal principal) {
        System.out.println(principal.getName() + " has created a new country.");
        CountryResponseDto countryResponseDto = countryService.create(countryCreateDto);
        return ResponseEntity.ok(countryResponseDto);
    }

    @GetMapping("/fingAll")
    public ResponseEntity<List<CountryFullDto>> findAllCountry(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                                   @RequestParam(defaultValue = "5") Integer pageSize,
                                                                   @RequestParam(defaultValue = "id") String sortBy) {
        List<CountryFullDto> listOfCountry = countryService.findAllCountrys(pageNumber, pageSize, sortBy);
        return ResponseEntity.ok(listOfCountry);
    }

    @GetMapping("/findByName")
    public ResponseEntity<CountryFullDto> findByName(@RequestParam String countryName) {
        CountryFullDto countryFullDto = countryService.findCountryByName(countryName);
        return ResponseEntity.ok(countryFullDto);
    }

    @GetMapping("/findById")
    public ResponseEntity<CountryFullDto> findById(@RequestParam Integer countryId) {
        CountryFullDto countryFullDto = countryService.findCountryByID(countryId);
        return ResponseEntity.ok(countryFullDto);
    }

    @GetMapping("/findByNameAndId")
    public ResponseEntity<CountryFullDto> findByNameAndId(@RequestParam String countryName,
                                                            @RequestParam Integer countryId) {
        CountryFullDto countryFullDto = countryService.findCountryByNameAndId(countryName, countryId);
        return ResponseEntity.ok(countryFullDto);
    }
}
