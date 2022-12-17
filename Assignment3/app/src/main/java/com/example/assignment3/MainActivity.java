package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    android.widget.Button btnLinear, btnRelative, btnConstraint, btnFrame, btnTable, btnGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLinear = findViewById(R.id.linearLayout);
        btnRelative = findViewById(R.id.relativeLayout);
        btnConstraint = findViewById(R.id.constraintLayout);
        btnFrame = findViewById(R.id.frameLayout);
        btnTable = findViewById(R.id.tableLayout);
        btnGrid = findViewById(R.id.gridLayout);

        btnLinear.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, LinearActivity.class);
            startActivity(i);
        });

        btnRelative.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, RelativeActivity.class);
            startActivity(i);
        });

        btnConstraint.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, ConstraintActivity.class);
            startActivity(i);
        });

        btnFrame.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, FrameActivity.class);
            startActivity(i);
        });

        btnTable.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, TableActivity.class);
            startActivity(i);
        });

        btnGrid.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, GridActivity.class);
            startActivity(i);
        });
    }
}