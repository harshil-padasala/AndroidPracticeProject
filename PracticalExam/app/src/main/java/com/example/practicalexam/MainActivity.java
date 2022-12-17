package com.example.practicalexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;


import java.util.Objects;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextInputEditText Username, Email, Id;
    Spinner SpinState, SpinCountry;
    Button Btn;

    String[] state = new String[]{"Gujarat", "Punjab", "Telangana", "Maharashtra", "Rajasthan", "MadhyaPradesh"};
    String[] country = new String[]{"India", "Australia", "America", "Canada", "Germany"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = findViewById(R.id.editUsername);
        Email = findViewById(R.id.editEmail);
        Id = findViewById(R.id.editStudentId);

        Btn = findViewById(R.id.nextBtn);

        SpinState = findViewById(R.id.spin_state);
        SpinState.setOnItemSelectedListener(this);
        SpinCountry = findViewById(R.id.spin_country);
        SpinCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, state[i] + " is Selected.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> stateArray = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, state);
        ArrayAdapter<String> countryArray = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, country);

        SpinCountry.setAdapter(countryArray);
        SpinState.setAdapter(stateArray);

        Btn.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, DetailsActivity.class);
            i.putExtra("username", Objects.requireNonNull(Username.getText()).toString());
            i.putExtra("email", Objects.requireNonNull(Email.getText()).toString());
            i.putExtra("id", Objects.requireNonNull(Id.getText()).toString());
            i.putExtra("state", state[SpinState.getSelectedItemPosition()]);
            i.putExtra("country", country[SpinCountry.getSelectedItemPosition()]);
            startActivity(i);

        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(MainActivity.this, country[i] + " is Selected.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}