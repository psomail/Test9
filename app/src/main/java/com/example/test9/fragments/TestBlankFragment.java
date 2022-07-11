package com.example.test9.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.example.test9.R;
import com.example.test9.models.HandlingUnit;
import com.example.test9.models.HandlingUnitsDatabase;
import com.google.zxing.Result;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TestBlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestBlankFragment extends Fragment {

    private HandlingUnitsDatabase database;

    private CodeScanner mCodeScanner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final Activity activity = getActivity();
        View root = inflater.inflate(R.layout.fragment_test_blank, container, false);
        CodeScannerView scannerView = root.findViewById(R.id.scanner_view);

        database = HandlingUnitsDatabase.getInstance(scannerView.getContext());

        mCodeScanner = new CodeScanner(activity, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String newHandlingUnit = result.getText().trim();
                        Toast.makeText(activity, "Added " + result.getText(), Toast.LENGTH_SHORT).show();
                        database.handlingUnitsDao().insertHandlingUnit(new HandlingUnit(newHandlingUnit, Calendar.getInstance()));
                    }
                });
            }
        });
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    public void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }
}