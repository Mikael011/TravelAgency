package com.sda.travelAgency.controller;

import com.sda.travelAgency.components.CustomFakerContinent;
import com.sda.travelAgency.dto.ContinentCreateDto;
import com.sda.travelAgency.dto.ContinentResponseDto;
import com.sda.travelAgency.model.Continent;
import com.sda.travelAgency.service.ContinentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/api/v1/continent")
@ControllerAdvice
public class ContinentController {

    private final ContinentService continentService;

    private final CustomFakerContinent customFakerContinent;

    public ContinentController(ContinentService continentService, CustomFakerContinent customFakerContinent) {
        this.continentService = continentService;
        this.customFakerContinent = customFakerContinent;
    }

    @GetMapping("/generateContinents")
    public void generateContinents() {
        List<Continent> listOfContinent = customFakerContinent.createDummyContinentList();
        continentService.saveAllContinents(listOfContinent);
    }

    @PostMapping("/createContinents")
    public ResponseEntity<ContinentResponseDto> createContinent(@RequestBody @Valid ContinentCreateDto continentCreateDto, Principal principal) {
        System.out.println(principal.getName() + " has created a new continent.");

        ContinentResponseDto continentResponseDto = continentService.create(continentCreateDto);

        return ResponseEntity.ok(continentResponseDto);
    }

    // TODO: 3/7/2022 De continuat

}
