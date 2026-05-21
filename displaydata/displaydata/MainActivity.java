package com.example.displaydata;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnDisplay;
    TextView txtData;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDisplay = findViewById(R.id.btnDisplay);
        txtData = findViewById(R.id.txtData);

        dbHelper = new DBHelper(this);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = dbHelper.getData();

                StringBuilder builder = new StringBuilder();

                while(cursor.moveToNext()) {

                    builder.append("ID : ")
                            .append(cursor.getInt(0))
                            .append("\n");

                    builder.append("Name : ")
                            .append(cursor.getString(1))
                            .append("\n");

                    builder.append("Age : ")
                            .append(cursor.getInt(2))
                            .append("\n\n");
                }

                txtData.setText(builder.toString());
            }
        });
    }
}