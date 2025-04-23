package com.vashchenko.ad231.configs;

import com.vashchenko.ad231.entities.Cat;
import com.vashchenko.ad231.entities.Dog;
import com.vashchenko.ad231.entities.Parrot;
import com.vashchenko.ad231.weekday.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Configuration
@ComponentScan("com.vashchenko.ad231.entities")
public class MyConfig {

    @Bean("parrot-kesha")
    public Parrot weNeedMoreParrots() {
        return new Parrot();
    }

    @Bean("cat")
    public Cat getCat(Parrot parrot) {
        Cat cat = new Cat();
        cat.setName(parrot.getName() + "-killer");
        return cat;
    }

    @Bean("dog")
    public Dog getDog() {
        Dog dog = new Dog();
        dog.setName("Bobik");
        return dog;
    }

    @Bean
    public WeekDay getDay() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY:
                return new Monday();
            case TUESDAY:
                return new Tuesday();
            case WEDNESDAY:
                return new Wednesday();
            case THURSDAY:
                return new Thursday();
            case FRIDAY:
                return new Friday();
            case SATURDAY:
                return new Saturday();
            default:
                return new Sunday();
        }
    }
}