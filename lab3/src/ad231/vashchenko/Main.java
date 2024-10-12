package ad231.vashchenko;

public class Main { // Клас ad231.vashchenko.Main

    // Метод main: Використовується для тестування методів
    public static void main(String[] args) {
        LabWork lab = new LabWork();  // Створюємо об'єкт класу ad231.vashchenko.LabWork

        // Тестування методу 1: перевірка, чи рядок закінчується на "ed"
        System.out.println("Метод 1: EndsWithEd");
        System.out.println("Result for 'started': " + lab.endsWithEd("started"));  // Очікується true
        System.out.println("Result for 'running': " + lab.endsWithEd("running"));  // Очікується false

        // Тестування методу 2: обчислення суми цифр у рядку
        System.out.println("\nМетод 2: SumOfDigits");
        System.out.println("Result for 'abc123xyz': " + lab.sumOfDigits("abc123xyz"));  // Очікується 6
        System.out.println("Result for 'noDigitsHere': " + lab.sumOfDigits("noDigitsHere"));  // Очікується 0

        // Тестування методу 3: знаходження довжини найдовшого блоку однакових символів
        System.out.println("\nМетод 3: LongestBlock");
        System.out.println("Result for 'aabbccddd': " + lab.longestBlock("aabbccddd"));  // Очікується 3
        System.out.println("Result for 'abcd': " + lab.longestBlock("abcd"));  // Очікується 1

        // Тестування методу 4: виведення слів з рядка
        System.out.println("\nМетод 4: PrintWords");
        System.out.println("Words in 'Hello world! This is a test.':");
        lab.printWords("Hello world! This is a test.");  // Виведе слова по одному на рядок

        // Тестування методу 5: з'єднання двох рядків по черзі символ за символом
        System.out.println("\nМетод 5: AlternateMerge");
        System.out.println("Result for 'abc' and '12345': " + lab.alternateMerge("abc", "12345"));  // "a1b2c345"
        System.out.println("Result for 'hello' and 'world': " + lab.alternateMerge("hello", "world"));  // "hweolrllod"
    }
}

