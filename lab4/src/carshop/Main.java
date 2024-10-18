package carshop;

import carshop.impl.MyOwnAutoShop;

// Головний клас програми для демонстрації роботи автосалону
public class Main {
    public static void main(String[] args) {
        // Створюємо об'єкт автосалону
        MyOwnAutoShop shop = new MyOwnAutoShop();

        // Купуємо автомобіль з індексом 1 (седан)
        shop.purchaseCar(1);

        // Виводимо сумарний дохід
        System.out.println("Total income: " + shop.getIncome());

        // Виводимо кольори всіх автомобілів
        System.out.println("Car colors: ");
        for (String color : shop.getCarColors()) {
            System.out.println(color);
        }
    }
}


