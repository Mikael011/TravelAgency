package com.sda.travelAgency.dto.ticket;

import com.sda.travelAgency.model.Ticket;
import javax.validation.constraints.NotBlank;

public class TicketCreateDto {

    @NotBlank(message = "Name is mandatory!")
    private String name;

    @NotBlank(message = "Name is mandatory")
    private Ticket ticket;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
