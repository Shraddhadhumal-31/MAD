package com.example.filehandlingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText etData;
    Button btnSave, btnRead;
    TextView tvResult;

    String fileName = "myfile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etData = findViewById(R.id.etData);
        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);
        tvResult = findViewById(R.id.tvResult);

        // Save Data
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data = etData.getText().toString();

                try {
                    FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();

                    Toast.makeText(MainActivity.this,
                            "Data saved successfully", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Read Data
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    FileInputStream fis = openFileInput(fileName);
                    int c;
                    String temp = "";

                    while ((c = fis.read()) != -1) {
                        temp += Character.toString((char) c);
                    }

                    tvResult.setText(temp);
                    fis.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}