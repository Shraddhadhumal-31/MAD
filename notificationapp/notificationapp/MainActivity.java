package com.example.notificationapp;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    Button btnNotify;
    String CHANNEL_ID = "my_channel_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotify = findViewById(R.id.btnNotify);

        // 🔔 Create Notification Channel (Android 8+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "My Channel",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel.setDescription("This is my notification channel");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        // 🔐 Request permission (Android 13+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(
                        new String[]{Manifest.permission.POST_NOTIFICATIONS},
                        101
                );
            }
        }

        // 🔘 Button Click Event
        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                                .setSmallIcon(android.R.drawable.ic_dialog_info)
                                .setContentTitle("Hello User 👋")
                                .setContentText("Notification is working successfully 🎉")
                                .setPriority(NotificationCompat.PRIORITY_HIGH)
                                .setAutoCancel(true);

                NotificationManagerCompat notificationManager =
                        NotificationManagerCompat.from(MainActivity.this);

                // Permission check again (important)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)
                            != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                }

                notificationManager.notify(1, builder.build());
            }
        });
    }
}