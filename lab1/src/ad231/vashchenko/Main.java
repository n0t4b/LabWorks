package ad231.vashchenko;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        // Виклик isNonDecreasing
        int[] arr = {1, 2, 2, 3};
        System.out.println("isNonDecreasing(arr): " + main.isNonDecreasing(arr));

        int[] arr2 = {3, 2, 1};
        System.out.println("isNonDecreasing(arr2): " + main.isNonDecreasing(arr2));

        // Виклик fizzBuzz
        System.out.println("FizzBuzz:");
        main.fizzBuzz();

        // Виклик canBeSplit
        int[] arr3 = {1, 1, 1, 2, 1};  // Приклад масиву для поділу
        System.out.println("canBeSplit(arr3): " + main.canBeSplit(arr3));

        int[] arr4 = {2, 1, 1, 2, 1};
        System.out.println("canBeSplit(arr4): " + main.canBeSplit(arr4));
    }

    // Метод для перевірки неубутності масиву
    public boolean isNonDecreasing(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Метод FizzBuzz
    public void fizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    // Метод для поділу масиву на дві рівні за сумою частини
    public boolean canBeSplit(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false; // Якщо сума непарна, поділити на рівні частини неможливо
        }

        int halfSum = 0;
        for (int num : arr) {
            halfSum += num;
            if (halfSum == totalSum / 2) {
                return true; // Знайдено поділ з рівними сумами
            }
        }

        return false;
    }
}
