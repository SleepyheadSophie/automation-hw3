package com.sleepyheadsophie.generator.person;

class MaleGenerator extends BaseGenerator {

    private final static String FIRST_NAMES_FILE_PATH = "MaleFirstName.txt";
    private final static String MIDDLE_NAMES_FILE_PATH = "MaleMiddleName.txt";
    private final static String LAST_NAMES_FILE_PATH = "MaleLastName.txt";

    MaleGenerator() {
        super(FIRST_NAMES_FILE_PATH, MIDDLE_NAMES_FILE_PATH, LAST_NAMES_FILE_PATH);
    }
}
