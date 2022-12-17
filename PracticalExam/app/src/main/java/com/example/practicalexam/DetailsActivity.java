package com.example.practicalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class DetailsActivity extends AppCompatActivity {

    String[] state = new String[]{"Gujarat", "Punjab", "Telangana", "Maharashtra", "Rajasthan", "MadhyaPradesh"};
    String[] country = new String[]{"India", "Australia", "America", "Canada", "Germany"};

    MaterialTextView Username, Email, Id, State, Country;

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
        State.setText(i.getStringExtra("state"));
        Country.setText(i.getStringExtra("country"));
    }
}