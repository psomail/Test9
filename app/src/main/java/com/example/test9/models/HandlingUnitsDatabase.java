package com.example.test9.models;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.test9.dao.HandlingUnitsDao;

@Database(entities = {HandlingUnit.class}, version = 1, exportSchema = false)
@TypeConverters({CalendarConverter.class})
public abstract class HandlingUnitsDatabase extends RoomDatabase {
    private static HandlingUnitsDatabase database;
    private static final String DB_NAME = "handling_units.db";
    private static final Object LOCK = new Object();

    public static HandlingUnitsDatabase getInstance(Context context){
        synchronized (LOCK){
            if(database == null){
                database = Room.databaseBuilder(context, HandlingUnitsDatabase.class, DB_NAME)
                        .allowMainThreadQueries() //must be remove
                        .build();
            }
            return database;
        }
    }

    public abstract HandlingUnitsDao handlingUnitsDao();
}
