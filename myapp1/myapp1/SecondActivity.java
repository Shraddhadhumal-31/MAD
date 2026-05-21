package com.example.myapp1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtResult = findViewById(R.id.txtResult);

        String name =
                getIntent().getStringExtra("username");

        txtResult.setText("Welcome " + name);
    }
}