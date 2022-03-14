package com.sda.travelAgency.dto.ticket;

import javax.validation.constraints.NotBlank;

public class TicketCreateDto {

    @NotBlank(message = "Name is mandatory!")
    private String name;

    @NotBlank(message = "Name is mandatory")
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
