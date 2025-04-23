package com.vashchenko.ad231.weekday;

import org.springframework.stereotype.Component;

@Component
public class Thursday implements WeekDay {
    @Override
    public String getWeekDayName() {
        return "thursday";
    }
}