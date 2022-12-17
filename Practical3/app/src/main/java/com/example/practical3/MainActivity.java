package com.example.practical3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    android.widget.Button btnFrame, btnTable, btnGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFrame = findViewById(R.id.frameLayout);
        btnTable = findViewById(R.id.tableLayout);
        btnGrid = findViewById(R.id.gridLayout);

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