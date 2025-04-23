package com.vashchenko.ad231.weekday;

import org.springframework.stereotype.Component;

@Component
public class Saturday implements WeekDay {
    @Override
    public String getWeekDayName() {
        return "saturday";
    }
}