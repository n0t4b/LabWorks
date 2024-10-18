package carshop.cars;

// Абстрактний клас Car, що є базовим для всіх автомобілів
public abstract class Car {
    int speed; // Швидкість автомобіля
    boolean isSellOut; // Прапорець, що вказує, чи автомобіль продано
    double regularPrice; // Стандартна ціна автомобіля
    private String color; // Колір автомобіля, приватне поле

    // Конструктор для ініціалізації основних полів автомобіля
    public Car(int speed, boolean isSellOut, double regularPrice, String color) {
        this.speed = speed;
        this.isSellOut = isSellOut;
        this.regularPrice = regularPrice;
        this.color = color;
    }

    // Геттер для отримання кольору автомобіля
    public String getColor() {
        return color;
    }

    // Сеттер для встановлення кольору автомобіля
    public void setColor(String color) {
        this.color = color;
    }

    // Абстрактний метод для отримання ціни зі знижкою, реалізується в дочірніх класах
    public abstract double getSalePrice();
}


