package com.sda.travelAgency.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tourId")
    private Integer tourId;

    @Column(name = "startingCity")
    private String startingCity;

    @Column(name="startingAirport")
    private String startingAirport;

    @Column(name="destinationCity")
    private String destinationCity;

    @Column(name = "destinationHotel")
    private String destinationHotel;

    @Column(name = "destinationAirport")
    private String destinationAirport;

    @Column(name="departureDate")
    private Date departureDate;

    @Column(name="dateOfReturn")
    private Date dateOfReturn;

    @Column(name = "numberOfDays")
    private Integer numberOfDays;

    @Column(name = "price")
    private Double price;

    @Column(name="priceChild")
    private Double priceChild;

    @Column(name="numberOfSeats")
    private Integer numberOfSeats;

}
