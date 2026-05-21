package com.example.sqlitedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge;
    Button btnSave;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        btnSave = findViewById(R.id.btnSave);

        dbHelper = new DBHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();
                String age = etAge.getText().toString();

                boolean check =
                        dbHelper.insertData(name, age);

                if(check) {

                    Toast.makeText(MainActivity.this,
                            "Data Inserted",
                            Toast.LENGTH_SHORT).show();
                }

                else {

                    Toast.makeText(MainActivity.this,
                            "Insertion Failed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}