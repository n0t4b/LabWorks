package com.vashchenko.ad231.weekday;

import org.springframework.stereotype.Component;

@Component
public class Wednesday implements WeekDay {
    @Override
    public String getWeekDayName() {
        return "wednesday";
    }
}