package com.example.practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;

public class DetailsActivity extends AppCompatActivity {

    String[] state = new String[]{"Gujarat", "Punjab", "Telangana", "Maharashtra", "Rajasthan", "MadhyaPradesh"};
    String[] country = new String[]{"India", "Australia", "America", "Canada", "Germany"};

    TextInputEditText Username, Email, Id, State, Country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Username = findViewById(R.id.user_name);
        Email = findViewById(R.id.email);
        Id = findViewById(R.id.id);
        State = findViewById(R.id.state);
        Country = findViewById(R.id.country);

        Intent i = getIntent();

        Username.setText(i.getStringExtra("username"));
        Email.setText(i.getStringExtra("email"));
        Id.setText(i.getStringExtra("id"));
        State.setText(state[Integer.parseInt(i.getStringExtra("state"))]);
        Country.setText(country[Integer.parseInt(i.getStringExtra("country"))]);
    }
}