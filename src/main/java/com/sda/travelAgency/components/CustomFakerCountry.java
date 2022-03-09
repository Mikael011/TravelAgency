package com.sda.travelAgency.components;

import com.github.javafaker.Faker;
import com.sda.travelAgency.model.Continent;
import com.sda.travelAgency.model.Country;

import java.util.ArrayList;
import java.util.List;

public class CustomFakerCountry {

    public List<Country> createDummyCountryList() {
        List<Country> countryList = new ArrayList<>();
        Faker faker = new Faker();
// TODO: 3/7/2022 nu sunt sigur ca este corect (faker.name().name() si (faker.idNumber().hashCode()))
        for (int i = 0; i < 500; i++) {
            Country country = new Country();
            country.setId(faker.idNumber().hashCode());
            country.setName(faker.name().name());
            countryList.add(country);
        }
        return countryList;
    }
}
