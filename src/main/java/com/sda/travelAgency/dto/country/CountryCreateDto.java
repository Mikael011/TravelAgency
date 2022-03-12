package com.sda.travelAgency.dto.country;

import com.sda.travelAgency.model.City;

import javax.validation.constraints.NotBlank;

public class CountryCreateDto {

    @NotBlank(message = "Name is mandatory!")
    private String name;

    @NotBlank(message = "Name is mandatory")
    private City city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
