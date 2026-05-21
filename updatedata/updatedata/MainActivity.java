package com.example.updatedata;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etId, etName, etAge;
    Button btnUpdate;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        btnUpdate = findViewById(R.id.btnUpdate);

        dbHelper = new DBHelper(this);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id =
                        etId.getText().toString();

                String name =
                        etName.getText().toString();

                String age =
                        etAge.getText().toString();

                boolean check =
                        dbHelper.updateData(id,
                                name,
                                age);

                if(check) {

                    Toast.makeText(MainActivity.this,
                            "Data Updated",
                            Toast.LENGTH_SHORT).show();
                }

                else {

                    Toast.makeText(MainActivity.this,
                            "Update Failed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}