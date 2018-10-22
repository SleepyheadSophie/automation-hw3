package com.sleepyheadsophie.generator.address;

import com.sleepyheadsophie.model.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AddressGenerator {

    private final static String COUNTRIES_FILE_PATH = "Countries.txt";
    private final static String REGIONS_FILE_PATH = "Regions.txt";
    private final static String CITIES_FILE_PATH = "Cities.txt";
    private final static String STREETS_FILE_PATH = "Streets.txt";

    private final static int MAX_INT_VALUE = 250;

    Random random = new Random();
    private List<String> countriesList = new ArrayList<>();
    private List<String> regionsList = new ArrayList<>();
    private List<String> citiesList = new ArrayList<>();
    private List<String> streetsList = new ArrayList<>();

    private int house;
    private int flat;
    private int index;

    public AddressGenerator() {
        try (BufferedReader countriesInput = new BufferedReader(new InputStreamReader(readFileFromResources(COUNTRIES_FILE_PATH), "UTF-8"));
             BufferedReader regionsInput = new BufferedReader(new InputStreamReader(readFileFromResources(REGIONS_FILE_PATH), "UTF-8"));
             BufferedReader citiesInput = new BufferedReader(new InputStreamReader(readFileFromResources(CITIES_FILE_PATH), "UTF-8"));
             BufferedReader streetsInput = new BufferedReader(new InputStreamReader(readFileFromResources(STREETS_FILE_PATH), "UTF-8"))
        ) {
            readFile(countriesInput, countriesList);
            readFile(regionsInput, regionsList);
            readFile(citiesInput, citiesList);
            readFile(streetsInput, streetsList);
        } catch (IOException e) {
            e.printStackTrace();

        }
        index = ThreadLocalRandom.current().nextInt(100000, 999999);
    }

    private void readFile(BufferedReader file, List<String> destination) throws IOException {
        String line;
        while ((line = file.readLine()) != null) {
            destination.add(line);

        }
    }

    private InputStream readFileFromResources(String path) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(path);
        return resourceAsStream;
    }

    public String getRandomCountry() {
        return countriesList.get(random.nextInt(countriesList.size()));
    }

    public String getRandomRegion() {
        return regionsList.get(random.nextInt(regionsList.size()));
    }

    public String getRandomCity() {
        return citiesList.get(random.nextInt(citiesList.size()));
    }

    public String getRandomStreet() {
        return streetsList.get(random.nextInt(streetsList.size()));
    }

    public int getRandomHouse() {
        return random.nextInt(MAX_INT_VALUE);
    }

    public int getRandomFlat() {
        return random.nextInt(MAX_INT_VALUE);
    }

    public int getRandomIndex() {
        return ThreadLocalRandom.current().nextInt(100000, 999999);
    }

    HttpClient httpClient = new HttpClient();
}
