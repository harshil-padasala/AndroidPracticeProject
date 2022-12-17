package com.example.a20ce064assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn;
        btn = findViewById(R.id.nextbtn);

        btn.setOnClickListener(view -> {

            TextInputEditText mobileNumber;
            mobileNumber = findViewById(R.id.editMobileNumber);

            String number = mobileNumber.getEditableText().toString();

            if (number.length() == 10) {
                Intent i = new Intent(MainActivity.this, SkillsActivity.class);
                startActivity(i);
                finish();
            }
            else {
                mobileNumber.setError("Invalid MobileNumber");
            }
        });
    }
}