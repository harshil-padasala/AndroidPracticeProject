package com.example.externalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String[] country = new String[]{"India", "Argentina", "Brazil", "Russia", "Germany", "England", "Ukraine", "America", "Australia", "New Zealand"};
    private final int[] images = new int[]{R.drawable.india, R.drawable.argentina, R.drawable.brazil, R.drawable.russia,
            R.drawable.germany, R.drawable.england, R.drawable.ukraine, R.drawable.america, R.drawable.australia, R.drawable.newz};
    Spinner SpinCountry;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpinCountry = findViewById(R.id.spin_country);
        image = findViewById(R.id.image);

        SpinCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, country[i] + " is Selected.", Toast.LENGTH_SHORT).show();
                image.setImageResource(images[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> countryArray = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, country);

        SpinCountry.setAdapter(countryArray);
    }
}