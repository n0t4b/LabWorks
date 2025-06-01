package com.example.electroniccard;

public class BankAccountDecorator extends CardDecorator {
    private String accountNumber;
    private double balance;
    private String bankName;

    public BankAccountDecorator(ElectronicCard decoratedCard, String accountNumber, double balance, String bankName) {
        super(decoratedCard);
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bankName = bankName;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("--- Данные банковской карты ---");
        System.out.println("Номер счета: " + accountNumber);
        System.out.println("Баланс: " + balance + " USD");
        System.out.println("Банк: " + bankName);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Внесено: " + amount + " USD. Новый баланс: " + this.balance + " USD");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Снято: " + amount + " USD. Новый баланс: " + this.balance + " USD");
        } else {
            System.out.println("Недостаточно средств или неверная сумма для снятия.");
        }
    }
}