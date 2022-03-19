package com.sda.travelAgency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "room_number")
    private Integer number;

    @Column(name = "room_capacity")
    private Integer capacity;

    @Column(name = "room_description")
    private String description;

    @ManyToOne
    private Hotel hotel;

}
