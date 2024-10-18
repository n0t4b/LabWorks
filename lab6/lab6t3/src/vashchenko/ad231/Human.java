package vashchenko.ad231;

public class Human implements Comparable<Human> {
    private String fName;  // Ім'я
    private String lName;  // Прізвище
    private int age;       // Вік

    public Human(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Human o) {
        int rez;
        if (this.equals(o)) return 0;
        rez = fName.compareToIgnoreCase(o.getfName());
        if (rez != 0) return rez;
        rez = lName.compareToIgnoreCase(o.getlName());
        if (rez != 0) return rez;
        else return age - o.getAge();
    }

    @Override
    public String toString() {
        return fName + " " + lName + ", Age: " + age;
    }
}
