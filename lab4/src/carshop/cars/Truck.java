package carshop.cars;

// Клас Truck, що розширює Car, і представляє вантажівку
public class Truck extends Car {
    int weight; // Вага вантажівки

    // Конструктор для ініціалізації полів вантажівки
    public Truck(int speed, boolean isSellOut, double regularPrice, String color, int weight) {
        super(speed, isSellOut, regularPrice, color);
        this.weight = weight;
    }

    // Метод для розрахунку ціни зі знижкою залежно від ваги
    @Override
    public double getSalePrice() {
        if (weight > 2000) {
            return regularPrice * 0.9; // Знижка 10% для важких вантажівок
        } else {
            return regularPrice; // Без знижки для легких вантажівок
        }
    }
}



