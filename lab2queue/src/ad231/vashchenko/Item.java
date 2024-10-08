package ad231.vashchenko;

public class Item {
    private String name; // Найменування товару
    private float price; // Ціна товару

    // Конструктор
    public Item(String name, float price) {
        this.name = name;
        this.price = price < 0 ? 0 : price; // Перевірка на негативну ціну
    }

    // Гетери
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    // Метод для підвищення ціни
    public void increasePrice(float percent) {
        if (percent > 0) {
            price += price * (percent / 100);
        }
    }

    // Метод для зниження ціни
    public void decreasePrice(float percent) {
        if (percent > 0) {
            price -= price * (percent / 100);
            if (price < 0) {
                price = 0; // Перевірка на негативне значення
            }
        }
    }
}

