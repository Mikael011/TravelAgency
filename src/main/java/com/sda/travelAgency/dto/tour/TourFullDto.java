package com.sda.travelAgency.dto.tour;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TourFullDto {
    private Integer tourId;

    private String startingCity;

    private String startingAirport;

    private String destinationCity;

    private String destinationHotel;

    private String destinationAirport;

    private Date dateOfReturn;

    private Date departureDate;

    private Integer numberOfDays;

    private Double price;

    private Double priceChild;

    private Integer numberOfSeats;
}
