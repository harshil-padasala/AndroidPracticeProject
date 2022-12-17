package com.example.assignment6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView selectedBirthDate;

    private TextInputEditText percentage12th, percentage10th;

    String[] cast = {"GEN/GC", "ST", "SC", "OBC"};

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin = findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cast);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(ad);

        android.widget.Button btnBirthDate = (android.widget.Button) findViewById(R.id.pick_date_button);
        selectedBirthDate = (TextView) findViewById(R.id.show_selected_date);
        android.widget.Button calculateResult = (android.widget.Button) findViewById(R.id.calculate_result);

        percentage10th = (TextInputEditText) findViewById(R.id.edit10thPercentage);
        percentage12th = (TextInputEditText) findViewById(R.id.edit12thPercentage);

        MaterialDatePicker.Builder<Long> materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTitleText("SELECT A DATE");
        final MaterialDatePicker<Long> materialDatePicker = materialDateBuilder.build();
        btnBirthDate.setOnClickListener(
                v -> materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER"));

        materialDatePicker.addOnPositiveButtonClickListener(
                (MaterialPickerOnPositiveButtonClickListener) selection -> selectedBirthDate.setText("Selected Date is : " + materialDatePicker.getHeaderText()));

        calculateResult.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, CalculateResult.class);
            startActivityForResult(i, 1);
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                assert data != null;
                float marks10th = data.getIntExtra("10thMarks", 0);
                float marks12th = data.getIntExtra("12thMarks", 0);

                Log.d("marks10th Main", Float.toString(marks10th));
                Log.d("marks12th Main", Float.toString(marks12th));

                percentage10th.setText(Float.toString(marks10th));
                percentage12th.setText(Float.toString(marks12th));
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}