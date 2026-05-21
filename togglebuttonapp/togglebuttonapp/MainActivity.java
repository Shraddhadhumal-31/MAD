package com.example.togglebuttonapp;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        tvStatus = findViewById(R.id.tvStatus);

        // Event Handler
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    tvStatus.setText("Status: ON");
                } else {
                    tvStatus.setText("Status: OFF");
                }
            }
        });
    }
}