package com.example.notificaion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "sexy channel";
    private static final int CHANNEL_ID_INT = 11;
    private static final int REQ_CODE = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDoit, btnPendingIntent, btnInboxStyle;

        btnDoit = findViewById(R.id.btnDoit);
        btnPendingIntent = findViewById(R.id.btnPendingIntent);
        btnInboxStyle = findViewById(R.id.btnInboxStyle);

        btnDoit.setOnClickListener(view -> {

            Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.notification, null);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = Objects.requireNonNull(bitmapDrawable).getBitmap();

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Notification notification;

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                notification = new Notification.Builder(this)
                        .setLargeIcon(bitmap)
                        .setSmallIcon(R.drawable.notification)
                        .setContentText("Notification")            // Title
                        .setSubText("SubNotification")
                        .setChannelId(CHANNEL_ID)
                        .build();

                notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "Channel",
                        NotificationManager.IMPORTANCE_HIGH));
            } else {
                notification = new Notification.Builder(this)
                        .setLargeIcon(bitmap)
                        .setSmallIcon(R.drawable.notification)
                        .setContentText("Notification")            // Title
                        .setSubText("SubNotification")
                        .build();
            }

            notificationManager.notify(CHANNEL_ID_INT, notification);
        });


        btnPendingIntent.setOnClickListener(view -> {
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.notification_1, null);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = Objects.requireNonNull(bitmapDrawable).getBitmap();

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Notification notification;


            // Pending Intent Object
            @SuppressLint("UnspecifiedImmutableFlag") PendingIntent pendingIntent = PendingIntent.getActivity(this, REQ_CODE,
                    new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP),
                    PendingIntent.FLAG_UPDATE_CURRENT);


            // Big Picture Style
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                    .bigPicture(((BitmapDrawable) Objects.requireNonNull(ResourcesCompat.getDrawable(getResources(),
                            R.drawable.notification_1, null))).getBitmap())
                    .bigLargeIcon(bitmap)
                    .setBigContentTitle("Sexy Image")
                    .setSummaryText("Sexy photo by Ananya");


            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                notification = new Notification.Builder(this)
                        .setLargeIcon(bitmap)
                        .setSmallIcon(R.drawable.notification)
                        .setContentText("Sexy Notification")            // Title
                        .setSubText("Sexy SubNotification")
                        .setChannelId(CHANNEL_ID)
                        .setContentIntent(pendingIntent)
                        .setStyle(bigPictureStyle)
                        .build();

                notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "Sexy Channel", NotificationManager.IMPORTANCE_HIGH));
            } else {
                notification = new Notification.Builder(this)
                        .setLargeIcon(bitmap)
                        .setSmallIcon(R.drawable.notification)
                        .setContentText("Sexy Notification")            // Title
                        .setSubText("Sexy SubNotification")
                        .setContentIntent(pendingIntent)
                        .setStyle(bigPictureStyle)
                        .build();
            }

            notificationManager.notify(CHANNEL_ID_INT, notification);
        });

        btnInboxStyle.setOnClickListener(view -> {
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.notification_1, null);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = Objects.requireNonNull(bitmapDrawable).getBitmap();

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Notification notification;


            // Pending Intent Object
            @SuppressLint("UnspecifiedImmutableFlag") PendingIntent pendingIntent = PendingIntent.getActivity(this, REQ_CODE,
                    new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP),
                    PendingIntent.FLAG_UPDATE_CURRENT);


            // Inbox Style
            Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                    .addLine("1")
                    .addLine("2")
                    .addLine("3")
                    .addLine("4")
                    .addLine("5")
                    .addLine("6")
                    .addLine("7")
                    .addLine("8")
                    .addLine("9")
                    .addLine("10")
                    .setBigContentTitle("Message is Displayed")
                    .setSummaryText("Message Form Girl");


            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                notification = new Notification.Builder(this)
                        .setLargeIcon(bitmap)
                        .setSmallIcon(R.drawable.notification)
                        .setContentText("Sexy Notification")            // Title
                        .setSubText("Sexy SubNotification")
                        .setChannelId(CHANNEL_ID)
                        .setContentIntent(pendingIntent)
                        .setStyle(inboxStyle)
                        .setOngoing(false)
                        .build();

                notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "Sexy Channel", NotificationManager.IMPORTANCE_HIGH));
            } else {
                notification = new Notification.Builder(this)
                        .setLargeIcon(bitmap)
                        .setSmallIcon(R.drawable.notification)
                        .setContentText("Sexy Notification")            // Title
                        .setSubText("Sexy SubNotification")
                        .setContentIntent(pendingIntent)
                        .setStyle(inboxStyle)
                        .setOngoing(true)
                        .build();
            }

            notificationManager.notify(CHANNEL_ID_INT, notification);
        });

    }
}