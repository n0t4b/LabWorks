package com.example.electroniccard;

public class InsurancePolicyDecorator extends CardDecorator {
    private String policyNumber;
    private String insuranceCompany;
    private String validityPeriod;

    public InsurancePolicyDecorator(ElectronicCard decoratedCard, String policyNumber, String insuranceCompany, String validityPeriod) {
        super(decoratedCard);
        this.policyNumber = policyNumber;
        this.insuranceCompany = insuranceCompany;
        this.validityPeriod = validityPeriod;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("--- Данные страхового полиса ---");
        System.out.println("Номер полиса: " + policyNumber);
        System.out.println("Страховая компания: " + insuranceCompany);
        System.out.println("Срок действия: " + validityPeriod);
    }

    public String getPolicyNumber() {
        return policyNumber;
    }
}