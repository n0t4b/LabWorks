package com.example.electroniccard;

public abstract class CardDecorator implements ElectronicCard {
    protected ElectronicCard decoratedCard;

    public CardDecorator(ElectronicCard decoratedCard) {
        this.decoratedCard = decoratedCard;
    }

    @Override
    public void displayInfo() {
        decoratedCard.displayInfo();
    }
}