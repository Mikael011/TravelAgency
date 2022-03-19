package com.sda.travelAgency.dto.tour;
import com.sda.travelAgency.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TourCreateDto {
    @NotBlank(message = "Name is mandatory!")
    private Integer tourId;

    @NotBlank(message = "Name is mandatory")
    private Ticket startingCity;

    @NotBlank(message = "Name is mandatory!")
    private String startingAirport;

    @NotBlank(message = "Name is mandatory")
    private Ticket destinationCity;

    @NotBlank(message = "Name is mandatory!")
    private String destinationHotel;

    @NotBlank(message = "Name is mandatory")
    private Ticket destinationAirport;

    @NotBlank(message = "Name is mandatory!")
    private String departureDate;

    @NotBlank(message = "Name is mandatory")
    private Ticket dateOfReturn;

    @NotBlank(message = "Name is mandatory!")
    private String numberOfDays;

    @NotBlank(message = "Name is mandatory")
    private Ticket price;


}
