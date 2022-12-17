package com.example.practical10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button ratingBtn, seekBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBtn = findViewById(R.id.rating);
        seekBtn = findViewById(R.id.seek);

        ratingBtn.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, RatingActivity.class));
        });

        seekBtn.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, SeekActivity.class));
        });
    }
}