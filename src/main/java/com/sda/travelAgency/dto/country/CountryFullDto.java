package com.sda.travelAgency.dto.country;

import com.sda.travelAgency.model.City;

public class CountryFullDto {

    private Integer id;
    private String name;
    private City city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
