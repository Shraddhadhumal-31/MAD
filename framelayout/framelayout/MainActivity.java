package com.example.framelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        back = findViewById(R.id.back);


        b1.setOnClickListener(v -> Toast.makeText(this, "Integer", Toast.LENGTH_SHORT).show());
        b2.setOnClickListener(v -> Toast.makeText(this, "Character", Toast.LENGTH_SHORT).show());
        b3.setOnClickListener(v -> Toast.makeText(this, "Float", Toast.LENGTH_SHORT).show());
        b4.setOnClickListener(v -> Toast.makeText(this, "Double", Toast.LENGTH_SHORT).show());
        b5.setOnClickListener(v -> Toast.makeText(this, "Boolean", Toast.LENGTH_SHORT).show());
        b6.setOnClickListener(v -> Toast.makeText(this, "String", Toast.LENGTH_SHORT).show());
        b7.setOnClickListener(v -> Toast.makeText(this, "Long", Toast.LENGTH_SHORT).show());
        b8.setOnClickListener(v -> Toast.makeText(this, "Short Int", Toast.LENGTH_SHORT).show());
        b9.setOnClickListener(v -> Toast.makeText(this, "Long Int", Toast.LENGTH_SHORT).show());


        back.setOnClickListener(v -> {
            Toast.makeText(this, "Back Pressed", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}