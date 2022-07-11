package com.example.test9.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test9.R;
import com.example.test9.models.HandlingUnit;
import com.example.test9.models.HandlingUnitsDatabase;

import java.util.Calendar;
import java.util.Date;

public class AddHandlingUnitActivity extends AppCompatActivity {

    private HandlingUnitsDatabase database;

    private EditText editTextHandlingUnit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_handling_unit);

        database = HandlingUnitsDatabase.getInstance(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        editTextHandlingUnit = findViewById(R.id.editTextHandlingUnit);
    }

    public void onClickAddHandlingUnit(View view) {
        String newHandlingUnit = editTextHandlingUnit.getText().toString().trim();
        if (isFilled(newHandlingUnit)) {
            database.handlingUnitsDao().insertHandlingUnit(new HandlingUnit(newHandlingUnit, Calendar.getInstance()));
            startActivity(new Intent(this, HandlingUnitsActivity.class));
        } else {
            Toast.makeText(this, "Handling Unit must not be empty", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isFilled(String handlingUnit){
        return !handlingUnit.isEmpty();
    }
}