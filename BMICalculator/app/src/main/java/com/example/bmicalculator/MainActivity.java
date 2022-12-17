package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Taking all references from XML
        EditText edtWeight = findViewById(R.id.edtWeight);
        EditText edtHeightF = findViewById(R.id.edtHeightF);
        EditText edtHeightI = findViewById(R.id.edtHeightI);
        TextView txtResult = findViewById(R.id.txtResult);
        Button calculate = findViewById(R.id.calculateBMI);
        LinearLayout llMain = findViewById(R.id.llMain);

//        setting on click listener
        calculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                int weight = Integer.parseInt(edtWeight.getText().toString());
                int heightF = Integer.parseInt(edtHeightF.getText().toString());
                int heightI = Integer.parseInt(edtHeightI.getText().toString());

                double totalMeters = (((heightF*12) + heightI)*2.53)/100;

                double bmi = weight/totalMeters;

                if (bmi > 25) {
                    txtResult.setText("You are overweight.");
                    llMain.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else if (bmi < 18) {
                    txtResult.setText("You are underWeight.");
                    llMain.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else {
                    txtResult.setText("You are Healthy.");
                    llMain.setBackgroundColor(getResources().getColor(R.color.green));
                }

            }
        });
    }
}