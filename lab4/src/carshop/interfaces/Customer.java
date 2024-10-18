package carshop.interfaces;

public interface Customer {
    double getCarsPrice();        // Метод для отримання ціни всіх автомобілів
    String[] getCarColors();      // Метод для отримання кольорів усіх автомобілів
    double getCarPrice(int id);   // Метод для отримання ціни автомобіля за ідентифікатором
    String getCarColor(int id);   // Метод для отримання кольору автомобіля за ідентифікатором
    void purchaseCar(int id);     // Метод для покупки автомобіля за ідентифікатором
}
