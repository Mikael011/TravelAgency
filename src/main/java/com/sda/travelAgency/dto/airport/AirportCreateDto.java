package com.sda.travelAgency.dto.airport;

import javax.validation.constraints.NotBlank;

public class AirportCreateDto {

    @NotBlank(message = "Name is mandatory!")
    private String name;

    private Integer cityId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
