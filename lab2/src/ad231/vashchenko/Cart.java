package ad231.vashchenko;

public class Cart {
    private final Item[] items; // Масив для зберігання товарів
    private int top; // Індекс для вершини стека
    private final int maxSize; // Максимальна кількість елементів у стеку

    // Конструктор
    public Cart(int maxSize) {
        this.maxSize = maxSize;
        items = new Item[maxSize];
        top = -1; // Стек порожній
    }

    // Перевірка, чи стек порожній
    public boolean isEmpty() {
        return top == -1;
    }

    // Перевірка, чи стек заповнений
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // Метод для додавання товару в стек
    public void addItem(Item item) {
        if (isFull()) {
            System.out.println("Кошик переповнений! Не можна додати новий товар.");
        } else {
            items[++top] = item; // Додаємо товар на вершину стека
            System.out.println("Товар '" + item.getName() + "' додано до кошика.");
        }
    }

    // Метод для видалення товару зі стека
    public Item removeItem() {
        if (isEmpty()) {
            System.out.println("Кошик порожній! Немає товарів для видалення.");
            return null;
        } else {
            Item removedItem = items[top--]; // Видаляємо товар з вершини стека
            System.out.println("Товар '" + removedItem.getName() + "' видалено з кошика.");
            return removedItem;
        }
    }

    // Метод для підрахунку суми цін товарів у кошику
    public float totalPrice() {
        float total = 0;
        for (int i = 0; i <= top; i++) {
            total += items[i].getPrice();
        }
        return total;
    }

    // Метод для підвищення ціни всіх товарів у кошику
    public void increasePrices(float percent) {
        for (int i = 0; i <= top; i++) {
            items[i].increasePrice(percent);
        }
        System.out.println("Ціни всіх товарів підвищено на " + percent + "%.");
    }

    // Метод для зниження ціни всіх товарів у кошику
    public void decreasePrices(float percent) {
        for (int i = 0; i <= top; i++) {
            items[i].decreasePrice(percent);
        }
        System.out.println("Ціни всіх товарів знижено на " + percent + "%.");
    }
}
