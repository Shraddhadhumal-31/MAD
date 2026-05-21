package com.example.exp6;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ToggleButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    CheckBox cbReading, cbPlaying, cbCoding;
    RadioGroup radioGroup;
    ToggleButton toggleBtn;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        cbReading = findViewById(R.id.cbReading);
        cbPlaying = findViewById(R.id.cbPlaying);
        cbCoding = findViewById(R.id.cbCoding);

        radioGroup = findViewById(R.id.radioGroup);
        toggleBtn = findViewById(R.id.toggleBtn);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(v -> {

            String name = etName.getText().toString();

            String hobbies = "";
            if (cbReading.isChecked()) hobbies += "Reading,";
            if (cbPlaying.isChecked()) hobbies += "Playing,";
            if (cbCoding.isChecked()) hobbies += "Coding ";

            int selectedId = radioGroup.getCheckedRadioButtonId();
            String gender = "";

            if (selectedId == R.id.rbMale) {
                gender = "Male";
            } else if (selectedId == R.id.rbFemale) {
                gender = "Female";
            }

            String notificationStatus = toggleBtn.isChecked() ? "Enabled" : "Disabled";
            String result = "Name: " + name +
                    "\nHobbies: " + hobbies +
                    "\nGender: " + gender +
                    "\nNotifications: " + notificationStatus;

            Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
        });

        toggleBtn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, "Notifications Enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Notifications Disabled", Toast.LENGTH_SHORT).show();
            }
        });
    }
}