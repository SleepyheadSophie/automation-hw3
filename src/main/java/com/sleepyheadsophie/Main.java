package com.sleepyheadsophie;

import com.sleepyheadsophie.generator.address.AddressGenerator;
import com.sleepyheadsophie.generator.other.BirthAndDateGenerator;
import com.sleepyheadsophie.generator.other.InnGenerator;

import com.sleepyheadsophie.model.*;

import java.io.IOException;

import java.time.LocalDate;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Файл создан. Путь: " + createAPIExcelFile());
        }



    /*private static String createExcelFile() {
        Random random = new Random();
        int personsAmount = 1 + random.nextInt(30);

        ExcelFile excelFile = new ExcelFile();
        excelFile.createWorkbook();

        AddressGenerator addressGenerator = new AddressGenerator();

        for (int i = 0; i < personsAmount; i++) {
            Gender genderValue = Gender.values()[random.nextInt(2)];
            PersonGenerator personGenerator = FactoryGenerator.getFactory(genderValue);

            Address address = new Address(addressGenerator);

            LocalDate dateOfBirth = BirthAndDateGenerator.getDateOfBirth();
            int age = BirthAndDateGenerator.getAge(dateOfBirth);
            String inn = InnGenerator.generateInn();

            Person person = new Person(personGenerator, genderValue, age, dateOfBirth, inn, address);

            excelFile.addRow(excelFile.getSheet(), i + 1, person, address);
        }
        excelFile.autoSizeColumns(excelFile.getSheet());
        return excelFile.saveWorkbook();
    }*/

    private static String createAPIExcelFile() throws IOException{
        int n;
        Random random = new Random();
        int personsAmount = 1 + random.nextInt(30);

        ExcelFile excelFile = new ExcelFile();
        excelFile.createWorkbook();
        String url = "https://randus.org/api.php";
        HttpClient httpClient = new HttpClient();


        AddressGenerator addressGenerator = new AddressGenerator();

        for (int i = 0; i < personsAmount; i++) {

            String jsonString = httpClient.getData(url);

            String g = httpClient.getAttribute(jsonString,"gender");
            if (g=="w"){
                n=1;
            }else{n=0;}

            Gender genderValue = Gender.values()[n];
            Address address = new Address(addressGenerator,httpClient,jsonString);

            LocalDate dateOfBirth = BirthAndDateGenerator.getDateOfBirth();
            int age = BirthAndDateGenerator.getAge(dateOfBirth);
            String inn = InnGenerator.generateInn();

            Person person = new Person(genderValue, age, inn, address, httpClient, jsonString);

            excelFile.addRow(excelFile.getSheet(), i + 1, person, address);
        }
        excelFile.autoSizeColumns(excelFile.getSheet());
        return excelFile.saveWorkbook();
    }
}
