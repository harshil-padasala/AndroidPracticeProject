package com.example.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class second_activity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txtFirstName, txtLastName, txtRollNo;
        txtFirstName = findViewById(R.id.firstName);
        txtLastName = findViewById(R.id.lastName);
        txtRollNo = findViewById(R.id.rollNo);

        Intent fromMainAct = getIntent();
        String title = fromMainAct.getStringExtra("title");
        String firstName = fromMainAct.getStringExtra("firstName");
        String lastName = fromMainAct.getStringExtra("lastName");
        int rollNo = fromMainAct.getIntExtra("rollNo", 0);

        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
        txtFirstName.setText("First name: " + firstName);
        txtLastName.setText("Last name: " + lastName);
        txtRollNo.setText("Roll No: " + rollNo);
    }
}