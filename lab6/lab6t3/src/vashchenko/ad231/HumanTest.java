package vashchenko.ad231;

import java.util.*;

public class HumanTest {
    public static void main(String[] args) {
        // Створюємо декілька об'єктів Human з іменами Nikita, Julia та Oleksandr
        Human h1 = new Human("Nikita", "Ivanov", 28);
        Human h2 = new Human("Julia", "Petrova", 25);
        Human h3 = new Human("Oleksandr", "Shevchenko", 30);

        // c) Створюємо колекцію на основі HashSet
        Set<Human> humanSet = new HashSet<>();
        humanSet.add(h1);
        humanSet.add(h2);
        humanSet.add(h3);

        System.out.println("HashSet collection:");
        for (Human h : humanSet) {
            System.out.println(h);
        }

        // d) Створюємо колекцію LinkedHashSet на основі існуючої колекції humanSet
        Set<Human> linkedHumanSet = new LinkedHashSet<>(humanSet);
        System.out.println("\nLinkedHashSet collection:");
        for (Human h : linkedHumanSet) {
            System.out.println(h);
        }

        // e) Створюємо колекцію TreeSet на основі існуючої колекції humanSet
        Set<Human> treeHumanSet = new TreeSet<>(humanSet);
        System.out.println("\nTreeSet collection (sorted by default):");
        for (Human h : treeHumanSet) {
            System.out.println(h);
        }

        // f) Створюємо порожню колекцію TreeSet з компаратором HumanComparatorByLName
        Set<Human> treeHumanSetByLName = new TreeSet<>(new HumanComparatorByLName());
        treeHumanSetByLName.addAll(humanSet);
        System.out.println("\nTreeSet collection (sorted by last name):");
        for (Human h : treeHumanSetByLName) {
            System.out.println(h);
        }

        // g) Створюємо порожню колекцію TreeSet з анонімним компаратором за віком
        Set<Human> treeHumanSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return h1.getAge() - h2.getAge();
            }
        });
        treeHumanSetByAge.addAll(humanSet);
        System.out.println("\nTreeSet collection (sorted by age):");
        for (Human h : treeHumanSetByAge) {
            System.out.println(h);
        }
    }
}

