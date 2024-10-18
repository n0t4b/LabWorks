package carshop.cars;

// Клас Ford, що розширює Car, і представляє автомобіль марки Ford
public class Ford extends Car {
    int year; // Рік випуску автомобіля
    int manufacturerDiscount; // Знижка від виробника

    // Конструктор для ініціалізації полів Ford
    public Ford(int speed, boolean isSellOut, double regularPrice, String color, int year, int manufacturerDiscount) {
        super(speed, isSellOut, regularPrice, color);
        this.year = year;
        this.manufacturerDiscount = manufacturerDiscount;
    }

    // Метод для розрахунку ціни зі знижкою від виробника
    @Override
    public double getSalePrice() {
        return regularPrice - manufacturerDiscount; // Віднімаємо знижку виробника
    }
}




