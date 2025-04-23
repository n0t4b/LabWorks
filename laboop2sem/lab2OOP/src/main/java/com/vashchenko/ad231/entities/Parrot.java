package com.vashchenko.ad231.entities;

import org.springframework.stereotype.Component;

@Component("parrot-kesha") // Явно задаем имя бина, как было раньше
public class Parrot {
    private String name = "Kesha";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}