package com.example.popupmenu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu = findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu =
                        new PopupMenu(MainActivity.this, btnMenu);

                popupMenu.getMenuInflater()
                        .inflate(R.menu.popup_menu,
                                popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(
                        new PopupMenu.OnMenuItemClickListener() {

                            @Override
                            public boolean onMenuItemClick(MenuItem item) {

                                if(item.getItemId() == R.id.item1) {
                                    Toast.makeText(MainActivity.this,
                                            "Home Selected",
                                            Toast.LENGTH_SHORT).show();
                                }

                                else if(item.getItemId() == R.id.item2) {
                                    Toast.makeText(MainActivity.this,
                                            "Profile Selected",
                                            Toast.LENGTH_SHORT).show();
                                }

                                else if(item.getItemId() == R.id.item3) {
                                    Toast.makeText(MainActivity.this,
                                            "Logout Selected",
                                            Toast.LENGTH_SHORT).show();
                                }

                                return true;
                            }
                        });

                popupMenu.show();
            }
        });
    }
}