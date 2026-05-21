package com.example.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    TextView tvResult;

    String[] courses = {"Select Course", "BCA", "BBA", "BSc", "MCA", "MBA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        tvResult = findViewById(R.id.tvResult);

        // Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                courses
        );

        spinner.setAdapter(adapter);

        // Event Handler (OnItemSelectedListener)
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selected = courses[position];
                tvResult.setText("Selected: " + selected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvResult.setText("Nothing Selected");
            }
        });
    }
}