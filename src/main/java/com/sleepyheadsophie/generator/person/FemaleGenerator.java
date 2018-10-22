package com.sleepyheadsophie.generator.person;

class FemaleGenerator extends BaseGenerator {

    private final static String FIRST_NAMES_FILE_PATH = "FemaleFirstName.txt";
    private final static String MIDDLE_NAMES_FILE_PATH = "FemaleMiddleName.txt";
    private final static String LAST_NAMES_FILE_PATH = "FemaleLastName.txt";

    FemaleGenerator() {
        super(FIRST_NAMES_FILE_PATH, MIDDLE_NAMES_FILE_PATH, LAST_NAMES_FILE_PATH);
    }
}