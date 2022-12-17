package com.example.externalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView Email, Username, FullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Email = findViewById(R.id.email);
        Username = findViewById(R.id.username);
        FullName = findViewById(R.id.fullName);

        Intent i = getIntent();

        Email.setText(i.getStringExtra("EMAIL"));
        Username.setText(i.getStringExtra("USERNAME"));
        FullName.setText(i.getStringExtra("FullName"));

    }
}