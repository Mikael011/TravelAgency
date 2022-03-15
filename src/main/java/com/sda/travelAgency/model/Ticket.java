package com.sda.travelAgency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tour_id")
    private Integer tourId;

    @Column(name = "price")
    private Double price;

    @Column(name = "participants")
    private Integer participants;

}
