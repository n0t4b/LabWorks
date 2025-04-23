package com.vashchenko.ad231.weekday;

import org.springframework.stereotype.Component;

@Component
public class Friday implements WeekDay {
    @Override
    public String getWeekDayName() {
        return "friday";
    }
}