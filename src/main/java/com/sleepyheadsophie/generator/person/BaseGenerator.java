package com.sleepyheadsophie.generator.person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class BaseGenerator implements PersonGenerator {

    private Random random = new Random();
    private List<String> firstNameList = new ArrayList<>();
    private List<String> middleNameList = new ArrayList<>();
    private List<String> lastNameList = new ArrayList<>();

    BaseGenerator(String firstNamesFilePath, String middleNamesFilePath, String lastNamesFilePath) {
        try (BufferedReader firstNameInput = new BufferedReader(new InputStreamReader(readFileFromResources(firstNamesFilePath), "UTF-8"));
             BufferedReader middleNameInput = new BufferedReader(new InputStreamReader(readFileFromResources(middleNamesFilePath), "UTF-8"));
             BufferedReader lastNameInput = new BufferedReader(new InputStreamReader(readFileFromResources(lastNamesFilePath), "UTF-8"))) {
            readFile(firstNameInput, firstNameList);
            readFile(middleNameInput, middleNameList);
            readFile(lastNameInput, lastNameList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFirstName() {
        return firstNameList.get(random.nextInt(firstNameList.size()));
    }

    public String getMiddleName() {
        return middleNameList.get(random.nextInt(middleNameList.size()));
    }

    public String getLastName() {
        return lastNameList.get(random.nextInt(lastNameList.size()));
    }

    private void readFile(BufferedReader file, List<String> destination) throws IOException {
        String line;
        while ((line = file.readLine()) != null) {
            destination.add(line);

        }
    }

    private InputStream readFileFromResources(String path) {
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResourceAsStream(path);
    }
}
