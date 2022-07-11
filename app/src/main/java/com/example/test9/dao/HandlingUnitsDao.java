package com.example.test9.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.test9.models.HandlingUnit;

import java.util.List;

@Dao
public interface HandlingUnitsDao {

    @Query("SELECT * FROM handling_units")
    List<HandlingUnit> getAllHandlingUnits();

    @Insert
    void insertHandlingUnit(HandlingUnit handlingUnit);

    @Delete
    void deleteHandlingUnit(HandlingUnit handlingUnit);

    @Query("DELETE FROM handling_units")
    void deleteAllHandlingUnits();
}
