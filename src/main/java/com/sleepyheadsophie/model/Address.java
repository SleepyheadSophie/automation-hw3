package com.sleepyheadsophie.model;

import com.sleepyheadsophie.generator.address.AddressGenerator;

public class Address {
    private String Country;
    private String Region;
    private String City;
    private String Street;
    private String house;
    private String flat;
    private String index;

    public Address(AddressGenerator addressGenerator, HttpClient httpClient, String jsonData) {
        Country = addressGenerator.getRandomCountry();
        Region = addressGenerator.getRandomRegion();
        City = httpClient.getAttribute(jsonData,"city");
        Street = httpClient.getAttribute(jsonData,"street");
        house = httpClient.getAttribute(jsonData,"house");
        flat = httpClient.getAttribute(jsonData,"apartment");
        index = httpClient.getAttribute(jsonData,"postcode");
    }

    public String getCountry() {
        return Country;
    }

    public String getRegion() {
        return Region;
    }

    public String getCity() {
        return City;
    }

    public String getStreet() {
        return Street;
    }

    public String getHouse() {
        return house;
    }

    public String getFlat() {
        return flat;
    }

    public String getIndex() {
        return index;
    }
}
