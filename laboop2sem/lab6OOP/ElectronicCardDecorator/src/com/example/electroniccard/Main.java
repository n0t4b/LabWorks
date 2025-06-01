package com.example.electroniccard;

public class Main {
    public static void main(String[] args) {
        System.out.println("Создаем базовую универсальную электронную карту:");
        ElectronicCard basicCard = new BasicCard("Иванов Иван", "1234-5678-9012-3456");
        basicCard.displayInfo();
        System.out.println("\n-----------------------------------\n");

        System.out.println("Добавляем функциональность паспорта:");
        ElectronicCard cardWithPassport = new PassportDecorator(basicCard, "АБ", "123456", "01.01.2020");
        cardWithPassport.displayInfo();
        if (cardWithPassport instanceof PassportDecorator) {
            System.out.println("Данные паспорта (через декоратор): " + ((PassportDecorator) cardWithPassport).getPassportData());
        }
        System.out.println("\n-----------------------------------\n");

        System.out.println("Добавляем функциональность страхового полиса к карте с паспортом:");
        ElectronicCard cardWithPassportAndInsurance = new InsurancePolicyDecorator(cardWithPassport, "ИНС-98765", "Росгосстрах", "до 31.12.2025");
        cardWithPassportAndInsurance.displayInfo();
        if (cardWithPassportAndInsurance instanceof InsurancePolicyDecorator) {
            System.out.println("Номер полиса (через декоратор): " + ((InsurancePolicyDecorator) cardWithPassportAndInsurance).getPolicyNumber());
        }
        System.out.println("\n-----------------------------------\n");

        System.out.println("Создаем новую карту с функциями паспорта, страхового полиса и банковской карты:");
        ElectronicCard fullFeaturedCard = new BasicCard("Петров Петр", "9876-5432-1098-7654");
        fullFeaturedCard = new PassportDecorator(fullFeaturedCard, "ВГ", "654321", "15.03.2021");
        fullFeaturedCard = new InsurancePolicyDecorator(fullFeaturedCard, "ОМС-11223", "МедСтрах", "бессрочно");
        fullFeaturedCard = new BankAccountDecorator(fullFeaturedCard, "40817810000000000001", 1500.0, "СберБанк");

        fullFeaturedCard.displayInfo();
        if (fullFeaturedCard instanceof BankAccountDecorator) {
            BankAccountDecorator bankCard = (BankAccountDecorator) fullFeaturedCard;
            System.out.println("Баланс (через декоратор): " + bankCard.getBalance() + " USD");
            bankCard.deposit(500.0);
            bankCard.withdraw(200.0);
            bankCard.withdraw(2000.0);
        }
        System.out.println("\n-----------------------------------\n");
    }
}