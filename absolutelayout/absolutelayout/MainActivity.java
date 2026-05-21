package com.example.absolutelayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone, etPassword;
    Button btnRegister, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);

        btnRegister = findViewById(R.id.btnRegister);
        btnClear = findViewById(R.id.btnClear);

        btnRegister.setOnClickListener(v -> {

            String name = etName.getText().toString();

            Toast.makeText(MainActivity.this,
                    "Registration Successful\nWelcome " + name,
                    Toast.LENGTH_LONG).show();
        });

        btnClear.setOnClickListener(v -> {

            etName.setText("");
            etEmail.setText("");
            etPhone.setText("");
            etPassword.setText("");

            Toast.makeText(MainActivity.this,
                    "Data Cleared",
                    Toast.LENGTH_SHORT).show();
        });
    }
}