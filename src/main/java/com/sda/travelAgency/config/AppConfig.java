package com.sda.travelAgency.config;

import com.sda.travelAgency.components.CustomFakerAirport;
import com.sda.travelAgency.components.CustomFakerContinent;
import com.sda.travelAgency.components.CustomFakerCountry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



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
    public CustomFakerAirport customFakerAirport (){
        return new CustomFakerAirport();



    }
}