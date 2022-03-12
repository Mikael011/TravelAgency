package com.sda.travelAgency.dto.room;

import javax.validation.constraints.NotBlank;

public class RoomCreateDto {

    @NotBlank(message = "Number is mandatory")
    private Integer number;

    private Integer capacity;

    private String description;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
