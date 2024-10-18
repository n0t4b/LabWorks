package vashchenko.ad231;

public class Lecturer extends Person {
    private String department;
    private double salary;

    // Конструктор
    public Lecturer(String lastName, String firstName, int age, String department, double salary) {
        super(lastName, firstName, age);
        this.department = department;
        this.salary = salary;
    }

    // Гетери і сетери
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Перевизначення методу printInfo
    @Override
    public String printInfo() {
        return "Викладач кафедри " + department + " " + getLastName() + " " + getFirstName() +
                ", вік: " + getAge() + ". Зарплата: " + salary;
    }
}

