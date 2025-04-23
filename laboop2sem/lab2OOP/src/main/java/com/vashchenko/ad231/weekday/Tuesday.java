package com.vashchenko.ad231.weekday;

import org.springframework.stereotype.Component;

@Component
public class Tuesday implements WeekDay {
    @Override
    public String getWeekDayName() {
        return "tuesday";
    }
}