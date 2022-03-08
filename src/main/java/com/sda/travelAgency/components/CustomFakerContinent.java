package com.sda.travelAgency.components;

import com.github.javafaker.Faker;
import com.sda.travelAgency.model.Continent;

import java.util.ArrayList;
import java.util.List;

public class CustomFakerContinent {

    public List<Continent> createDummyContinentList() {
        List<Continent> continentList = new ArrayList<>();
        Faker faker = new Faker();
// TODO: 3/7/2022 nu sunt sigur ca este corect (faker.name().name() si (faker.idNumber().hashCode()))
        for (int i = 0; i < 500; i++) {
            Continent continent = new Continent();
            continent.setId(faker.idNumber().hashCode());
            continent.setName(faker.name().name());
            continentList.add(continent);
        }
        return continentList;
    }

}
