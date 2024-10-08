package ad231.vashchenko;

import java.util.LinkedList;

public class Cart {
    private final LinkedList<Item> items; // Використовуємо LinkedList для реалізації черги
    private final int maxSize; // Максимальна кількість елементів у черзі

    // Конструктор
    public Cart(int maxSize) {
        this.maxSize = maxSize;
        this.items = new LinkedList<>(); // Ініціалізація черги
    }

    // Перевірка, чи черга порожня
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Перевірка, чи черга заповнена
    public boolean isFull() {
        return items.size() >= maxSize;
    }

    // Метод для додавання товару в чергу
    public void addItem(Item item) {
        if (isFull()) {
            System.out.println("Кошик переповнений! Не можна додати новий товар.");
        } else {
            items.add(item); // Додаємо товар в кінець черги
            System.out.println("Товар '" + item.getName() + "' додано до кошика.");
        }
    }

    // Метод для видалення товару з черги
    public Item removeItem() {
        if (isEmpty()) {
            System.out.println("Кошик порожній! Немає товарів для видалення.");
            return null;
        } else {
            Item removedItem = items.remove(); // Видаляємо товар з початку черги
            System.out.println("Товар '" + removedItem.getName() + "' видалено з кошика.");
            return removedItem;
        }
    }

    // Метод для підрахунку суми цін товарів у кошику
    public float totalPrice() {
        float total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // Метод для підвищення ціни всіх товарів у кошику
    public void increasePrices(float percent) {
        for (Item item : items) {
            item.increasePrice(percent);
        }
        System.out.println("Ціни всіх товарів підвищено на " + percent + "%.");
    }

    // Метод для зниження ціни всіх товарів у кошику
    public void decreasePrices(float percent) {
        for (Item item : items) {
            item.decreasePrice(percent);
        }
        System.out.println("Ціни всіх товарів знижено на " + percent + "%.");
    }
}
