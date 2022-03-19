package com.sda.travelAgency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "city_name")
    private String name;

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "city")
    private Set<Airport> airports;

    @OneToMany(mappedBy = "city")
    private Set<Hotel> hotels;

}
