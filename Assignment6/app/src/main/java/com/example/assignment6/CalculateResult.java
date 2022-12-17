package com.example.assignment6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class CalculateResult extends AppCompatActivity {

    TextInputEditText scienceMarks, mathsMarks, socialScienceMarks, gujaratiMarks, englishMarks, computerMarks;
    TextInputEditText chemistryMarks, maths12thMarks, physicsMarks, computer12thMarks;
    android.widget.Button calculateResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_result);

        // defining id
        scienceMarks = (TextInputEditText) findViewById(R.id.editScienceMarks);
        mathsMarks = (TextInputEditText) findViewById(R.id.editMathsMarks);
        socialScienceMarks = (TextInputEditText) findViewById(R.id.editSocialScienceMarks);
        gujaratiMarks = (TextInputEditText) findViewById(R.id.editGujaratiMarks);
        englishMarks = (TextInputEditText) findViewById(R.id.editEnglishMarks);
        computerMarks = (TextInputEditText) findViewById(R.id.editComputerMarks);

        chemistryMarks = (TextInputEditText) findViewById(R.id.editChemistryMarks);
        maths12thMarks = (TextInputEditText) findViewById(R.id.editMaths12thMarks);
        physicsMarks = (TextInputEditText) findViewById(R.id.editPhysicsMarks);
        computer12thMarks = (TextInputEditText) findViewById(R.id.editComputer12thMarks);

        calculateResult = (android.widget.Button) findViewById(R.id.calculate_result);
        calculateResult.setOnClickListener(view -> {

            if (!Objects.requireNonNull(scienceMarks.getText()).toString().equals("") ||
                    !Objects.requireNonNull(mathsMarks.getText()).toString().equals("") ||
                    !Objects.requireNonNull(socialScienceMarks.getText()).toString().equals("") ||
                    !Objects.requireNonNull(gujaratiMarks.getText()).toString().equals("") ||
                    !Objects.requireNonNull(englishMarks.getText()).toString().equals("") ||
                    !Objects.requireNonNull(computerMarks.getText()).toString().equals("") ||
                    !Objects.requireNonNull(chemistryMarks.getText()).toString().equals("") ||
                    !Objects.requireNonNull(maths12thMarks.getText()).toString().equals("") ||
                    !Objects.requireNonNull(physicsMarks.getText()).toString().equals("") ||
                    !Objects.requireNonNull(computer12thMarks.getText()).toString().equals("")) {

                int science = Integer.parseInt(Objects.requireNonNull(scienceMarks.getText()).toString());
                int maths = Integer.parseInt(Objects.requireNonNull(mathsMarks.getText()).toString());
                int socialScience = Integer.parseInt(Objects.requireNonNull(socialScienceMarks.getText()).toString());
                int gujarati = Integer.parseInt(Objects.requireNonNull(gujaratiMarks.getText()).toString());
                int english = Integer.parseInt(Objects.requireNonNull(englishMarks.getText()).toString());
                int computer = Integer.parseInt(Objects.requireNonNull(computerMarks.getText()).toString());
                int chemistry = Integer.parseInt(Objects.requireNonNull(chemistryMarks.getText()).toString());
                int maths12th = Integer.parseInt(Objects.requireNonNull(maths12thMarks.getText()).toString());
                int physics = Integer.parseInt(Objects.requireNonNull(physicsMarks.getText()).toString());
                int computer12th = Integer.parseInt(Objects.requireNonNull(computer12thMarks.getText()).toString());

                float i1 = (science + maths + socialScience + gujarati + english + computer) / 600;
                float marks10th = i1 * 100;
                Log.d("Total 10th: ", String.valueOf(i1));

                float i2 = (chemistry + maths12th + physics + computer12th) / 400;
                float marks12th = i2 * 100;
                Log.d("Total 12th: ", String.valueOf(i2));

                Intent i = new Intent(CalculateResult.this, MainActivity.class);
                i.putExtra("10thMarks", marks10th);
                i.putExtra("12thMarks", marks12th);

                setResult(RESULT_OK, i);
                finish();
            } else {
                Toast.makeText(this, "Marks cannot be empty...", Toast.LENGTH_SHORT).show();
            }

        });

    }
}