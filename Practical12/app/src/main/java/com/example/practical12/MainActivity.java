package com.example.practical12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    TextInputEditText Whether;
    MaterialButton btn;
    MaterialTextView WhetherText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Whether = findViewById(R.id.city);
        btn = findViewById(R.id.bthGetWhether);
        WhetherText = findViewById(R.id.whetherData);


    }
}