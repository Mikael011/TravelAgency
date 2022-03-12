package com.sda.travelAgency.dto.city;

import javax.validation.constraints.NotBlank;

public class CityCreateDto {

    @NotBlank(message = "Name is mandatory!")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
