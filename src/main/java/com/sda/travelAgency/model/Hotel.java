package com.sda.travelAgency.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "hotel_name")
    private String name;

    @Column(name = "numberOfStars")
    private Integer numberOfStars;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "hotel")
    private Set<Room> roomSet;

    @ManyToOne(cascade = CascadeType.ALL)// TODO: 3/19/2022 ?
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;


}

