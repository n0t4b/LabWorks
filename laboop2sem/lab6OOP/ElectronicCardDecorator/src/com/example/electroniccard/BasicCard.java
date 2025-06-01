package com.example.electroniccard;

public class BasicCard implements ElectronicCard {
    private String ownerName;
    private String cardNumber;

    public BasicCard(String ownerName, String cardNumber) {
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println("--- Базовая информация о карте ---");
        System.out.println("Владелец: " + ownerName);
        System.out.println("Номер карты: " + cardNumber);
    }
}