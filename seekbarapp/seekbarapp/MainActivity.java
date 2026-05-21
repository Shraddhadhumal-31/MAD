package com.example.seekbarapp;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView tvValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        tvValue = findViewById(R.id.tvValue);

        // Event Handler
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvValue.setText("Value: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                tvValue.setText("Started");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tvValue.setText("Final Value: " + seekBar.getProgress());
            }
        });
    }
}