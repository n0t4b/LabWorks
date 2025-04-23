package com.vashchenko.ad231.weekday;

import org.springframework.stereotype.Component;

@Component
public class Sunday implements WeekDay {
    @Override
    public String getWeekDayName() {
        return "sunday";
    }
}