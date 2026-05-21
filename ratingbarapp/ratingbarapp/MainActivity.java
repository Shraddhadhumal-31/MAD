package com.example.ratingbarapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    Button btnShow;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        btnShow = findViewById(R.id.btnShow);
        tvResult = findViewById(R.id.tvResult);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float rating = ratingBar.getRating();
                tvResult.setText("Selected Rating: " + rating);
            }
        });
    }
}