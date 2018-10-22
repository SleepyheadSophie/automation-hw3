package com.sleepyheadsophie.model;

import com.sleepyheadsophie.generator.person.PersonGenerator;

import java.time.LocalDate;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private int age;
    private String dateOfBirth;
    private String inn;
    private Address address;


    public Person(Gender gender, int age, String inn, Address address, HttpClient httpClient, String jsonData) {
        this.firstName = httpClient.getAttribute(jsonData,"fname");
        this.middleName = httpClient.getAttribute(jsonData,"patronymic");
        this.lastName = httpClient.getAttribute(jsonData,"lname");
        this.gender = gender;
        this.age = age;
        this.dateOfBirth = httpClient.getAttribute(jsonData,"date");
        this.inn = inn;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getInn() {
        return inn;
    }
}
