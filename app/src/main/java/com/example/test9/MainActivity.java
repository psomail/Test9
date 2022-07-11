package com.example.test9;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.test9.activities.HandlingUnitsActivity;
import com.example.test9.activities.TestBarcode;
import com.example.test9.activities.TestMaterial;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    public void onClickStartHandlingUnits(View view) {
        startActivity(new Intent(this, HandlingUnitsActivity.class));
    }

    public void onClickTestBarcode(View view) {
        startActivity(new Intent(this, TestBarcode.class));
    }

    public void onClickTestMaterial(View view) {
        startActivity(new Intent(this, TestMaterial.class));
    }
}