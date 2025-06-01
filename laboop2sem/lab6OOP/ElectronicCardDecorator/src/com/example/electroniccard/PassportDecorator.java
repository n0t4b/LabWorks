package com.example.electroniccard;

public class PassportDecorator extends CardDecorator {
    private String passportSeries;
    private String passportNumber;
    private String dateOfIssue;

    public PassportDecorator(ElectronicCard decoratedCard, String passportSeries, String passportNumber, String dateOfIssue) {
        super(decoratedCard);
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.dateOfIssue = dateOfIssue;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("--- Данные паспорта ---");
        System.out.println("Серия: " + passportSeries);
        System.out.println("Номер: " + passportNumber);
        System.out.println("Дата выдачи: " + dateOfIssue);
    }

    public String getPassportData() {
        return "Паспорт: " + passportSeries + " " + passportNumber;
    }
}