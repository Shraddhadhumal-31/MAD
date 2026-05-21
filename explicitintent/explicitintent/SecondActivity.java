package com.example.explicitintent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvResult = findViewById(R.id.tvResult);

        // Receiving data
        String name = getIntent().getStringExtra("studentName");
        String course = getIntent().getStringExtra("studentCourse");
        String marks = getIntent().getStringExtra("studentMarks");

        String result =
                "Student Details\n\n" +
                        "Name : " + name + "\n" +
                        "Course : " + course + "\n" +
                        "Marks : " + marks;

        tvResult.setText(result);
    }
}
