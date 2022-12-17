package com.example.a20ce064practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.onCreate);
        textView.setText("Activity is created.");
        Log.d("onCreate", "Activity is created");
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onStart() {
        textView = findViewById(R.id.onStart);
        textView.setText("Activity is started");
        Log.d("onStart", "Activity is started.");
        super.onStart();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        textView = findViewById(R.id.onResume);
        textView.setText("Activity is resumed");
        Log.d("onResume", "Activity is resumed.");
        super.onResume();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onPause() {
        textView = findViewById(R.id.onPause);
        textView.setText("Activity is paused");
        Log.d("onPause", "Activity is paused.");
        super.onPause();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onStop() {
        textView = findViewById(R.id.onStop);
        textView.setText("Activity is stopped");
        Log.d("onStop", "Activity is stopped.");
        super.onStop();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onRestart() {
        textView = findViewById(R.id.onRestart);
        textView.setText("Activity is restarted");
        Log.d("onRestart", "Activity is restarted.");
        super.onRestart();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onDestroy() {
        textView = findViewById(R.id.onDestroy);
        textView.setText("Activity is destroyed");
        Log.d("onDestroy", "Activity is destroyed.");
        super.onDestroy();
    }
}