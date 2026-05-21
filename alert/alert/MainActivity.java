package com.example.alert;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = findViewById(R.id.btnShow);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Exit App");
                builder.setMessage("Are you sure you want to exit?");

                // Positive Button
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(MainActivity.this, "Exiting...", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                // Negative Button
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                // Neutral Button
                builder.setNeutralButton("Help", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(MainActivity.this, "Help Clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                // Show dialog
                builder.show();
            }
        });
    }
}