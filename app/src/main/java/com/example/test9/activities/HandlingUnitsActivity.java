package com.example.test9.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.test9.R;
import com.example.test9.adapters.HandlingUnitsAdapter;
import com.example.test9.models.HandlingUnit;
import com.example.test9.models.HandlingUnitsDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HandlingUnitsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewHandlingUnits;
    HandlingUnitsAdapter adapter;
    private HandlingUnitsDatabase database;

    public static final List<HandlingUnit> handlingUnits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handling_units);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        database = HandlingUnitsDatabase.getInstance(this);

//        if (handlingUnits.isEmpty()){
//            handlingUnits.add(new HandlingUnit("W202202220000000149", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202220000000150", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202220000000151", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202220000000152", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202220000000153", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202220000000154", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202220000000155", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202220000000156", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202220000000157", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202220000000158", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202220000000159", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202220000000160", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202220000000161", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202220000000162", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202220000000163", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202220000000164", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202220000000165", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202220000000166", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202240000000001", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202250000000001", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202250000000002", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202250000000003", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202250000000004", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202250000000005", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202250000000006", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202250000000007", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202250000000008", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202250000000009", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202250000000010", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202280000000001", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202280000000002", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202280000000003", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202280000000004", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202250000000005", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202250000000006", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202250000000007", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202250000000008", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202250000000009", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202250000000010", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202280000000001", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202280000000002", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202280000000003", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202280000000004", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202280000000005", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202280000000006", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202280000000007", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202280000000008", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202280000000009", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202280000000010", new Date()));
//            handlingUnits.add(new HandlingUnit("W202202280000000011", new Date()));
//            handlingUnits.add(new HandlingUnit("W202203010000000001", new Date()));
//            handlingUnits.add(new HandlingUnit("W202203010000000002", new Date()));
//        }

        //getData();

        recyclerViewHandlingUnits = findViewById(R.id.recyclerViewHandlingUnits);
        recyclerViewHandlingUnits.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HandlingUnitsAdapter(handlingUnits);
        recyclerViewHandlingUnits.setAdapter(adapter);

        adapter.setOnHandlingUnitClickListener(new HandlingUnitsAdapter.OnHandlingUnitClickListener() {
            @Override
            public void onHandlingUnitClick(int position) {
                Toast.makeText(HandlingUnitsActivity.this, "Position " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onHandlingUnitLongClick(int position) {
                remove(position);
            }
        });

        // remove item through swipe
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                remove(viewHolder.getAdapterPosition());
            }
        });

        itemTouchHelper.attachToRecyclerView(recyclerViewHandlingUnits);
    }

    public void onClickAddHandlingUnit(View view) {
        //startActivity(new Intent(this, AddHandlingUnitActivity.class));

        startActivity(new Intent(this, TestBarcode.class));

    }

    @Override
    public void onTopResumedActivityChanged(boolean isTopResumedActivity) {
        super.onTopResumedActivityChanged(isTopResumedActivity);

        if(isTopResumedActivity){
            getData();
            adapter.notifyDataSetChanged();
        }
    }



    private void remove(int position){
        HandlingUnit handlingUnit = handlingUnits.get(position);
        database.handlingUnitsDao().deleteHandlingUnit(handlingUnit);
        getData();
        adapter.notifyDataSetChanged();
    }

    private void getData(){
        List<HandlingUnit> handlingUnitsFromDB = database.handlingUnitsDao().getAllHandlingUnits();
        handlingUnits.clear();
        handlingUnits.addAll(handlingUnitsFromDB);
    }

}