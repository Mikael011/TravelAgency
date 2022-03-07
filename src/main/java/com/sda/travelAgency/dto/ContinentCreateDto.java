package com.sda.travelAgency.dto;

import javax.validation.constraints.NotBlank;

public class ContinentCreateDto {

    @NotBlank(message = "Name is mandatory!")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
