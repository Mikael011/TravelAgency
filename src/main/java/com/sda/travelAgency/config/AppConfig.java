package com.sda.travelAgency.config;

import com.sda.travelAgency.components.CustomFakerContinent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CustomFakerContinent customFakerContinent() {
        return new CustomFakerContinent();
    }
}
