package com.example.a20ce064assignment2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SkillsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

        TextInputEditText pwd;
        Button btn;

        btn = findViewById(R.id.btnSubmit);
        pwd = findViewById(R.id.editPassword);

        btn.setOnClickListener(view -> {
            Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show();

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Notification notification;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notification = new Notification.Builder(this)
                        .setLargeIcon(((BitmapDrawable) Objects.requireNonNull(ResourcesCompat.getDrawable(getResources(), R.drawable.man, null))).getBitmap())
                        .setSmallIcon(R.drawable.man)
                        .setContentText("Your response has been recorded.")
                        .setSubText("User Created")
                        .setChannelId("register")
                        .build();

                notificationManager.createNotificationChannel(new NotificationChannel("register", "Registration", NotificationManager.IMPORTANCE_HIGH));
            } else {
                notification = new Notification.Builder(this)
                        .setLargeIcon(((BitmapDrawable) Objects.requireNonNull(ResourcesCompat.getDrawable(getResources(), R.drawable.man, null))).getBitmap())
                        .setSmallIcon(R.drawable.man)
                        .setContentText("Your response has been recorded.")
                        .setSubText("User Created1")
                        .build();
            }

            if (validatePassword(pwd.getEditableText().toString().trim())) {
                notificationManager.notify(11, notification);
                showAlertDialog();
                Intent i = new Intent(SkillsActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            } else {
                pwd.setError("password is to weak...");
            }
        });
    }

    private boolean validatePassword(String password) {
        final Pattern PASSWORD_PATTERN =
                Pattern.compile("^" +           // represents starting char
                        "(?=.*[0-9])" +         // represents a digit must occur at least once.
                        "(?=.*[a-z])" +         // represents a lower case alphabet must occur at least once.
                        "(?=.*[A-Z])" +         // represents an upper case alphabet that must occur at least once.
                        "(?=.*[@#$%&-+=()])" +     // represents a special character that must occur at least once.
                        "(?=\\S+$)" +           // white spaces don’t allowed in the entire string.
                        ".{8,20}" +             //  represents at least 8 characters and at most 20 characters.
                        "$");                   // represents the end of the string.


        // password is not empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        Matcher matcher = PASSWORD_PATTERN.matcher(password);

        return matcher.matches();
    }

    // method for showing AlertDialog
    public void showAlertDialog() {
        AlertDialog.Builder twoBtnDialog = new AlertDialog.Builder(SkillsActivity.this);
        twoBtnDialog.setTitle("Login");
        twoBtnDialog.setIcon(R.drawable.ic_baseline_login_24);
        twoBtnDialog.setMessage("User Logged in");

        twoBtnDialog.setPositiveButton("Yes", (dialogInterface, i) -> {
            Toast.makeText(SkillsActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        });

        twoBtnDialog.setNegativeButton("No", (dialogInterface, i) -> Toast.makeText(SkillsActivity.this, "Ok", Toast.LENGTH_SHORT).show());

        twoBtnDialog.setNeutralButton("Cancel", (dialogInterface, i) -> Toast.makeText(SkillsActivity.this, "Okay", Toast.LENGTH_SHORT).show());

        twoBtnDialog.show();
    }
}