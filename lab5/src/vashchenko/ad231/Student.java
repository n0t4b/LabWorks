package vashchenko.ad231;

public class Student extends Person {
    private String group;
    private String studentId;

    // Конструктор
    public Student(String lastName, String firstName, int age, String group, String studentId) {
        super(lastName, firstName, age);
        this.group = group;
        this.studentId = studentId;
    }

    // Гетери і сетери
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // Перевизначення методу printInfo
    @Override
    public String printInfo() {
        return "Студент групи " + group + " " + getLastName() + " " + getFirstName() +
                ", вік: " + getAge() + ". Номер студентського квитка: " + studentId;
    }
}

