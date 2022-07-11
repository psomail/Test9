package com.example.test9.models;

import androidx.room.TypeConverter;

import java.util.Calendar;

public class CalendarConverter {

    @TypeConverter
    public static Calendar toCalendar(Long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar;
    }

    @TypeConverter
    public static Long fromCalendar(Calendar calendar){
        return calendar == null ? null : calendar.getTime().getTime();
    }
}
