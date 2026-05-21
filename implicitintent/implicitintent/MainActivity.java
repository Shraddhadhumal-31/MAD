package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnWebsite, btnDial, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWebsite = findViewById(R.id.btnWebsite);
        btnDial = findViewById(R.id.btnDial);
        btnEmail = findViewById(R.id.btnEmail);

        // Open Website
        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com"));

                startActivity(intent);
            }
        });

        // Open Dialer
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        Intent.ACTION_DIAL,
                        Uri.parse("tel:9876543210"));

                startActivity(intent);
            }
        });

        // Send Email
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.setType("message/rfc822");

                intent.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"abc@gmail.com"});

                intent.putExtra(Intent.EXTRA_SUBJECT,
                        "Hello");

                intent.putExtra(Intent.EXTRA_TEXT,
                        "This is Implicit Intent Example");

                startActivity(Intent.createChooser(intent,
                        "Choose Email App"));
            }
        });
    }
}