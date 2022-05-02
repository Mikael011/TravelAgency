package com.sda.travelAgency.dto.airport;

import com.sda.travelAgency.dto.city.CityFullDto;
import com.sda.travelAgency.model.City;

public class AirportFullDto {

    private Integer id;
    private String name;
    private CityFullDto city;

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
    public int getCityId() {
        return city.getId();
    }
    public void setCity(CityFullDto city) {
        this.city = city;
    }

    public CityFullDto getCity() {
        return city;
    }
}
