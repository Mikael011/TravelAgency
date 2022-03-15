package com.sda.travelAgency.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Hotel {

    @javax.persistence.Id // TODO: 3/15/2022 asta pentru ce e?
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "hotel_name")

    private String name;

    @Column(name = "numberOfStars")
    private Integer numberOfStars;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City cityId;

}

