package com.example.gridlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4,
            btn5, btn6, btn7, btn8;

    GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = findViewById(R.id.gridLayout);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btn1) {
            gridLayout.setBackgroundColor(Color.RED);
        }

        else if(v.getId() == R.id.btn2) {
            gridLayout.setBackgroundColor(Color.BLUE);
        }

        else if(v.getId() == R.id.btn3) {
            gridLayout.setBackgroundColor(Color.GREEN);
        }

        else if(v.getId() == R.id.btn4) {
            gridLayout.setBackgroundColor(Color.YELLOW);
        }

        else if(v.getId() == R.id.btn5) {
            gridLayout.setBackgroundColor(Color.CYAN);
        }

        else if(v.getId() == R.id.btn6) {
            gridLayout.setBackgroundColor(Color.MAGENTA);
        }

        else if(v.getId() == R.id.btn7) {
            gridLayout.setBackgroundColor(Color.GRAY);
        }

        else if(v.getId() == R.id.btn8) {
            gridLayout.setBackgroundColor(Color.BLACK);
        }
    }
}