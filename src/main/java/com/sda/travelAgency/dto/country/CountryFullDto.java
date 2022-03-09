package com.sda.travelAgency.dto.country;

import com.sda.travelAgency.model.Continent;

public class CountryFullDto {

    private Integer id;
    private String name;
    private Continent continent;

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

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}
