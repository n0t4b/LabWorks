package vashchenko.ad231;

public class Main {
    public static void main(String[] args) {
        // Створення об'єктів
        Student student1 = new Student("Коваль", "Олег", 20, "НАД-231", "123456");
        Student student2 = new Student("Іваненко", "Анна", 22, "НАД-232", "654321");
        Lecturer lecturer1 = new Lecturer("Петров", "Ігор", 45, "Комп'ютерні науки", 15000.0);
        Lecturer lecturer2 = new Lecturer("Сидоренко", "Олена", 50, "Математика", 18000.0);

        // Масив типу Person, що містить об'єкти класів Student та Lecturer
        Person[] people = {student1, student2, lecturer1, lecturer2};

        // Виведення інформації про кожен об'єкт за допомогою методу printInfo()
        for (Person person : people) {
            System.out.println(person.printInfo());
        }
    }
}
