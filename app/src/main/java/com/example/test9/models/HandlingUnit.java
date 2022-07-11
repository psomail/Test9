package com.example.test9.models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Date;

@Entity(tableName = "handling_units")
public class HandlingUnit {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String handlingUnit;
    private Calendar createCalendar;

    public HandlingUnit(int id, String handlingUnit, Calendar createCalendar) {
        this.id = id;
        this.handlingUnit = handlingUnit;
        this.createCalendar = createCalendar;
    }

    @Ignore
    public HandlingUnit(String handlingUnit, Calendar createCalendar) {
        this.handlingUnit = handlingUnit;
        this.createCalendar = createCalendar;
    }

    public int getId() {
        return id;
    }

    public String getHandlingUnit() {
        return handlingUnit;
    }

    public Calendar getCreateCalendar() {
        return createCalendar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHandlingUnit(String handlingUnit) {
        this.handlingUnit = handlingUnit;
    }

    public void setCreateCalendar(Calendar createCalendar) {
        this.createCalendar = createCalendar;
    }
}
