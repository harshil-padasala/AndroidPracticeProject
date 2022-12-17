package com.example.practical51;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // create an array of an University Name
    String[] universityName = {"Charusat University", "Nirma University", "University of Delhi",
            "Vellore institute of Technology", "Chandigarh University", "SRM Institute of Science and Technology",
            "Indian Institute of Bombay", "Indian Institute of Madras", "Punjab University"};

    int[] images = {R.drawable.school1, R.drawable.school2, R.drawable.school3, R.drawable.school4,
            R.drawable.school5, R.drawable.school6, R.drawable.school7, R.drawable.school8,
            R.drawable.school9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spin = findViewById(R.id.coursesSpinner);
        spin.setOnItemSelectedListener(this);

        // Create the instance of ArrayAdapter having the list of university name
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, universityName);

        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the Spinner which binds data to spinner
        spin.setAdapter(ad);
    }

    // Performing action when ItemSelected
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

        // set image on click
        ImageView imageView = findViewById(R.id.universityImage);
        imageView.setImageResource(images[position]);
        Toast.makeText(this, universityName[position], Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // set image on click
        ImageView imageView = findViewById(R.id.universityImage);
        imageView.setImageResource(R.drawable.school1);

    }
}