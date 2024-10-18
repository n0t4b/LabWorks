package vashchenko.ad231;

import java.util.Comparator;

public class HumanComparatorByLName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getlName().compareToIgnoreCase(h2.getlName());
    }
}

