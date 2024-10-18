package carshop.impl;

import carshop.cars.Ford;
import carshop.cars.Sedan;
import carshop.cars.Truck;
import carshop.interfaces.Admin;
import carshop.interfaces.Customer;

// Клас MyOwnAutoShop, що реалізує інтерфейси Admin і Customer
public class MyOwnAutoShop implements Admin, Customer {
    // Ініціалізуємо об'єкти різних типів автомобілів
    Sedan sedan = new Sedan(200, true, 20000, "Red", 25);
    Ford ford1 = new Ford(180, false, 25000, "Blue", 2020, 2000);
    Ford ford2 = new Ford(190, true, 30000, "Black", 2019, 2500);
    Truck truck1 = new Truck(160, true, 40000, "White", 2500);
    Truck truck2 = new Truck(140, false, 35000, "Green", 1800);

    // Сумарний дохід від продажів
    double income = 0;

    // Реалізація методу для отримання сумарного доходу
    @Override
    public double getIncome() {
        return income;
    }

    // Реалізація методу для отримання загальної вартості всіх автомобілів
    @Override
    public double getCarsPrice() {
        return sedan.getSalePrice() + ford1.getSalePrice() + ford2.getSalePrice() + truck1.getSalePrice() + truck2.getSalePrice();
    }

    // Реалізація методу для отримання масиву кольорів автомобілів
    @Override
    public String[] getCarColors() {
        return new String[]{sedan.getColor(), ford1.getColor(), ford2.getColor(), truck1.getColor(), truck2.getColor()};
    }

    // Реалізація методу для отримання ціни автомобіля за індексом
    @Override
    public double getCarPrice(int id) {
        switch (id) {
            case 1: return sedan.getSalePrice();
            case 2: return ford1.getSalePrice();
            case 3: return ford2.getSalePrice();
            case 4: return truck1.getSalePrice();
            case 5: return truck2.getSalePrice();
            default: return 0;
        }
    }

    // Реалізація методу для отримання кольору автомобіля за індексом
    @Override
    public String getCarColor(int id) {
        switch (id) {
            case 1: return sedan.getColor();
            case 2: return ford1.getColor();
            case 3: return ford2.getColor();
            case 4: return truck1.getColor();
            case 5: return truck2.getColor();
            default: return "Unknown";
        }
    }

    // Реалізація методу для купівлі автомобіля за індексом, додає ціну до доходу
    @Override
    public void purchaseCar(int id) {
        income += getCarPrice(id);
    }
}



