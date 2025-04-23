package com.vashchenko.ad231;

import com.vashchenko.ad231.configs.MyConfig;
import com.vashchenko.ad231.entities.Cat;
import com.vashchenko.ad231.entities.Dog;
import com.vashchenko.ad231.entities.Parrot;
import com.vashchenko.ad231.weekday.WeekDay;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Cat cat = context.getBean("cat", Cat.class);
        Dog dog = context.getBean("dog", Dog.class); // Получаем бин Dog по имени "dog"
        Parrot parrot = context.getBean("parrot-kesha", Parrot.class);
        WeekDay weekDay = context.getBean(WeekDay.class);

        System.out.println(cat.getName());
        System.out.println(dog.getName());
        System.out.println(parrot.getName());
        System.out.println("Today is: " + weekDay.getWeekDayName());
    }
}