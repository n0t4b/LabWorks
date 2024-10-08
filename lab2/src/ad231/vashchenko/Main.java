package ad231.vashchenko;

public class Main {
    public static void main(String[] args) {
        // Створення об'єкта класу Cart з максимальною кількістю елементів
        Cart cart = new Cart(5); // Максимум 5 товарів у кошику

        // Заповнення кошика об'єктами класу Item
        cart.addItem(new Item("Товар 1", 100.0f));
        cart.addItem(new Item("Товар 2", 150.0f));
        cart.addItem(new Item("Товар 3", 200.0f));
        cart.addItem(new Item("Товар 4", 250.0f));
        cart.addItem(new Item("Товар 5", 300.0f));

        // Виведення суми цін товарів усередині кошика
        float total = cart.totalPrice();
        System.out.println("Сума цін товарів у кошику: " + total);

        // Підвищення цін в кошику на 15%
        cart.increasePrices(15);
        float newTotalAfterIncrease = cart.totalPrice();
        System.out.println("Сума цін товарів після підвищення на 15%: " + newTotalAfterIncrease);

        // Зниження цін в кошику на 30%
        cart.decreasePrices(30);
        float newTotalAfterDecrease = cart.totalPrice();
        System.out.println("Сума цін товарів після зниження на 30%: " + newTotalAfterDecrease);

        // Видалення товару з кошика
        cart.removeItem(); // Видаляємо останній доданий товар
        float totalAfterRemoval = cart.totalPrice();
        System.out.println("Сума цін товарів після видалення одного товару: " + totalAfterRemoval);
    }
}
