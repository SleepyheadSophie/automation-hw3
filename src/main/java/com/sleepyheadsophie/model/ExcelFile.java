package com.sleepyheadsophie.model;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ExcelFile {

    private static final String WORKBOOK_NAME = "TestData.xlsx";
    private static final String SHEET_NAME = "TestData";
    private Workbook workbook;
    private Sheet sheet;

    public Sheet createWorkbook() {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet(SHEET_NAME);
        Row header = sheet.createRow(0);
        CellStyle headerStyle = workbook.createCellStyle();
        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setBold(true);
        headerStyle.setFont(font);
        header.setRowStyle(headerStyle);
        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Имя");
        headerCell = header.createCell(1);
        headerCell.setCellValue("Фамилия");
        headerCell = header.createCell(2);
        headerCell.setCellValue("Отчество");
        headerCell = header.createCell(3);
        headerCell.setCellValue("Возраст");
        headerCell = header.createCell(4);
        headerCell.setCellValue("Пол");
        headerCell = header.createCell(5);
        headerCell.setCellValue("Дата рождения");
        headerCell = header.createCell(6);
        headerCell.setCellValue("Инн");
        headerCell = header.createCell(7);
        headerCell.setCellValue("Почтовый индекс");
        headerCell = header.createCell(8);
        headerCell.setCellValue("Страна");
        headerCell = header.createCell(9);
        headerCell.setCellValue("Область");
        headerCell = header.createCell(10);
        headerCell.setCellValue("Город");
        headerCell = header.createCell(11);
        headerCell.setCellValue("Улица");
        headerCell = header.createCell(12);
        headerCell.setCellValue("Дом");
        headerCell = header.createCell(13);
        headerCell.setCellValue("Квартира");
        return sheet;
    }

    public void addRow(Sheet sheet, int num, Person person, Address address) {
        Row row = sheet.createRow(num);
        addCell(row, 0, person.getFirstName());
        addCell(row, 1, person.getMiddleName());
        addCell(row, 2, person.getLastName());
        addCell(row, 3, String.valueOf(person.getAge()));
        addCell(row, 4, person.getGender().toString());
        addCell(row, 5, person.getDateOfBirth());
        addCell(row, 6, String.valueOf(person.getInn()));
        addCell(row, 7, String.valueOf(address.getIndex()));
        addCell(row, 8, address.getCountry());
        addCell(row, 9, address.getRegion());
        addCell(row, 10, address.getCity());
        addCell(row, 11, address.getStreet());
        addCell(row, 12, String.valueOf(address.getHouse()));
        addCell(row, 13, String.valueOf(address.getFlat()));
    }

    private void addCell(Row row, int num, String value) {
        Cell cell = row.createCell(num);
        cell.setCellValue(value);
    }

    public void autoSizeColumns(Sheet sheet) {
        for (int i = 0; i < 14; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    public String saveWorkbook() {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + WORKBOOK_NAME;

        try (FileOutputStream fileOut = new FileOutputStream(fileLocation)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileLocation;
    }

    public Sheet getSheet() {
        return sheet;
    }
}