package com.example.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMain = findViewById(R.id.btnMain);
        Intent iNext = new Intent(MainActivity.this, second_activity.class);
        iNext.putExtra("title", "Information");
        iNext.putExtra("firstName", "Harshil");
        iNext.putExtra("lastName", "Padasala");
        iNext.putExtra("rollNo", 40);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iNext);
            }
        });
    }
}