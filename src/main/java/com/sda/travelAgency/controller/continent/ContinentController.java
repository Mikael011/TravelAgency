package com.sda.travelAgency.controller.continent;

import com.sda.travelAgency.components.CustomFakerContinent;
import com.sda.travelAgency.dto.continent.ContinentCreateDto;
import com.sda.travelAgency.dto.continent.ContinentFullDto;
import com.sda.travelAgency.dto.continent.ContinentResponseDto;
import com.sda.travelAgency.model.Continent;
import com.sda.travelAgency.service.impl.continent.ContinentService;
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

    public ContinentController(ContinentService continentService, CustomFakerContinent customFakerContinent) {// am avut eroare la 'customFakerContinent' pana nu am facut clasa AppConfig si in ea
        this.continentService = continentService;
        this.customFakerContinent = customFakerContinent;
    }

    @GetMapping("/generate")
    public void generateContinents() {
        List<Continent> listOfContinent = customFakerContinent.createDummyContinentList();
        continentService.saveAllContinents(listOfContinent);
    }

    @PostMapping("/create")
    public ResponseEntity<ContinentResponseDto> createContinent(@RequestBody @Valid ContinentCreateDto continentCreateDto, Principal principal) {
        System.out.println(principal.getName() + " has created a new continent.");
        ContinentResponseDto continentResponseDto = continentService.create(continentCreateDto);
        return ResponseEntity.ok(continentResponseDto);
    }

    @GetMapping("/fingAll")
    public ResponseEntity<List<ContinentFullDto>> findAllContinent(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                                   @RequestParam(defaultValue = "5") Integer pageSize,
                                                                   @RequestParam(defaultValue = "id") String sortBy) {
        List<ContinentFullDto> listOfContinent = continentService.findAllContinents(pageNumber, pageSize, sortBy);
        return ResponseEntity.ok(listOfContinent);
    }

    @GetMapping("/findByName")
    public ResponseEntity<ContinentFullDto> findByName(@RequestParam String continentName) {
        ContinentFullDto continentFullDto = continentService.findContinentByName(continentName);
        return ResponseEntity.ok(continentFullDto);
    }

    @GetMapping("/findById")
    public ResponseEntity<ContinentFullDto> findById(@RequestParam Integer continentId) {
        ContinentFullDto continentFullDto = continentService.findContinentById(continentId);
        return ResponseEntity.ok(continentFullDto);
    }

    @GetMapping("/findByNameAndId")
    public ResponseEntity<ContinentFullDto> findByNameAndId(@RequestParam String continentName,
                                                            @RequestParam Integer continentId) {
        ContinentFullDto continentFullDto = continentService.findContinentByNameAndId(continentName, continentId);
        return ResponseEntity.ok(continentFullDto);
    }
}
