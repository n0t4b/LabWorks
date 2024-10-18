package vashchenko.ad231;

import java.util.*;

public class ListOperations {
    public static void main(String[] args) {
        // a) Створіть масив із N випадкових чисел
        int N = 10; // Кількість елементів у масиві
        Random rand = new Random();
        Integer[] array = new Integer[N];

        // Заповнюємо масив випадковими числами від 0 до 100
        for (int i = 0; i < N; i++) {
            array[i] = rand.nextInt(101); // Випадкові числа від 0 до 100
        }

        System.out.println("Initial array: " + Arrays.toString(array));

        // b) На основі масиву створіть список List
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("Initial list: " + list);

        // c) Відсортуйте список у натуральному порядку
        Collections.sort(list);
        System.out.println("Sorted list: " + list);

        // d) Відсортуйте список у зворотному порядку
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Reverse sorted list: " + list);

        // e) Перемішайте список
        Collections.shuffle(list);
        System.out.println("Shuffled list: " + list);

        // f) Виконайте циклічний зсув на 1 елемент
        Collections.rotate(list, 1);
        System.out.println("Rotated list: " + list);

        // g) Залишіть у списку лише унікальні елементи
        Set<Integer> uniqueSet = new HashSet<>(list);
        List<Integer> uniqueList = new ArrayList<>(uniqueSet);
        System.out.println("Unique elements: " + uniqueList);

        // h) Залишіть у списку лише елементи, що дублюються
        Set<Integer> duplicates = new HashSet<>();
        List<Integer> duplicateList = new ArrayList<>();
        for (Integer i : list) {
            if (!duplicates.add(i)) {
                duplicateList.add(i);
            }
        }
        System.out.println("Duplicate elements: " + duplicateList);

        // i) Зі списку отримайте масив
        Integer[] resultArray = list.toArray(new Integer[0]);
        System.out.println("Array from list: " + Arrays.toString(resultArray));
    }
}

