package com.sda.travelAgency.dto.hotel;

import com.sda.travelAgency.model.City;

import javax.validation.constraints.NotBlank;

public class HotelCreateDto {

    @NotBlank(message = "Name is mandatory!")
    private String name;

    @NotBlank(message = "Name is mandatory")
    private City cityId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

