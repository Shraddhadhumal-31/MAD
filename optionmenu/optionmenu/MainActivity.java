package com.example.optionmenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Attach Menu XML
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    // Event Handler
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.home) {
            Toast.makeText(this, "Home Selected", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.profile) {
            Toast.makeText(this, "Profile Selected", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.settings) {
            Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.logout) {
            Toast.makeText(this, "Logout Selected", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}