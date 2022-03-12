package com.sda.travelAgency.config;

import com.sda.travelAgency.components.CustomFakerAirport;
import com.sda.travelAgency.components.CustomFakerContinent;
import com.sda.travelAgency.components.CustomFakerCountry;
import com.sda.travelAgency.dto.country.CountryCreateDto;
import com.sda.travelAgency.dto.country.CountryFullDto;
import com.sda.travelAgency.dto.country.CountryResponseDto;
import com.sda.travelAgency.model.Country;
import com.sda.travelAgency.service.impl.country.CountryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public CustomFakerContinent customFakerContinent() {
        return new CustomFakerContinent();
    }

    @Bean
    public CustomFakerCountry customFakerCountry() {
        return new CustomFakerCountry();
    }


    @Bean
    public CustomFakerAirport customFakerAirport() {
        return new CustomFakerAirport();
    }
}
