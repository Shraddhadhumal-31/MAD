package com.example.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etCourse, etMarks;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etCourse = findViewById(R.id.etCourse);
        etMarks = findViewById(R.id.etMarks);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {

            String name = etName.getText().toString();
            String course = etCourse.getText().toString();
            String marks = etMarks.getText().toString();

            if(name.isEmpty() || course.isEmpty() || marks.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
            else {

                // Explicit Intent
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                // Passing data
                intent.putExtra("studentName", name);
                intent.putExtra("studentCourse", course);
                intent.putExtra("studentMarks", marks);

                startActivity(intent);
            }

        });
    }
}
