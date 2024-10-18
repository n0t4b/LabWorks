package vashchenko.ad231;

public class Person {
    private String lastName;
    private String firstName;
    private int age;

    // Конструктор
    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    // Гетери і сетери
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Метод для виведення інформації
    public String printInfo() {
        return "Людина " + lastName + " " + firstName + ", вік: " + age;
    }
}

