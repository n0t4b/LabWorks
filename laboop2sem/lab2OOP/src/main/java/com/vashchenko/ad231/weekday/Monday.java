package com.vashchenko.ad231.weekday;

import org.springframework.stereotype.Component;

@Component
public class Monday implements WeekDay {
    @Override
    public String getWeekDayName() {
        return "monday";
    }
}