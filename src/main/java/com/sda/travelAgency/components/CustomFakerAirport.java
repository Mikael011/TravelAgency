package com.sda.travelAgency.components;

import com.github.javafaker.Faker;
import com.sda.travelAgency.model.Airport;

import java.util.ArrayList;
import java.util.List;

public class CustomFakerAirport {

    public List<Airport> createDummyContinentList() {
        List<Airport> airportList = new ArrayList<>();
        Faker faker = new Faker();
// TODO: 3/7/2022 nu sunt sigur ca este corect (faker.name().name() si (faker.idNumber().hashCode()))
        for (int i = 0; i < 500; i++) {
            Airport airport = new Airport();
            airport.setId(faker.idNumber().hashCode());
            airport.setName(faker.name().name());
            airportList.add(airport);
        }
        return airportList;
    }
}
