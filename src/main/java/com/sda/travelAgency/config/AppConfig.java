package com.sda.travelAgency.config;

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
    public CountryService countryService() {
        return new CountryService() {
            @Override
            public CountryResponseDto create(CountryCreateDto countryCreateDto) {
                return null;
            }

            @Override
            public CountryFullDto findCountryByID(Integer id) {
                return null;
            }

            @Override
            public CountryFullDto findCountryByName(String name) {
                return null;
            }

            @Override
            public CountryFullDto findCountryByNameAndId(String name, Integer id) {
                return null;
            }

            @Override
            public void saveAllCountrys(List<Country> listOfCountrys) {

            }

            @Override
            public List<CountryFullDto> findAllCountrys(Integer pageNumber, Integer pageSize, String sortBy) {
                return null;
            }

            @Override
            public List<CountryFullDto> findAllCountrys() {
                return null;
            }
        };
    }
}
