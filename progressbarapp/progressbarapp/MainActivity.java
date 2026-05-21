package com.example.progressbarapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView tvProgress;
    Button btnStart;

    int progress = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        tvProgress = findViewById(R.id.tvProgress);
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progress = 0;

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        while (progress <= 100) {

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(progress);
                                    tvProgress.setText(progress + "%");
                                }
                            });

                            try {
                                Thread.sleep(100); // delay
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            progress++;
                        }
                    }
                }).start();
            }
        });
    }
}