package carshop.cars;

// Клас Sedan, що розширює Car, і представляє автомобіль типу седан
public class Sedan extends Car {
    int length; // Довжина автомобіля

    // Конструктор для ініціалізації полів седана
    public Sedan(int speed, boolean isSellOut, double regularPrice, String color, int length) {
        super(speed, isSellOut, regularPrice, color);
        this.length = length;
    }

    // Метод для розрахунку ціни зі знижкою залежно від довжини автомобіля
    @Override
    public double getSalePrice() {
        if (length > 20) {
            return regularPrice * 0.95; // Знижка 5% для довгих автомобілів
        } else {
            return regularPrice; // Без знижки для коротких автомобілів
        }
    }
}




