package com.example.externalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView FullName, UserName, Email, Password;
    Button BtnSubmit;

    private final String EMAIL = "20ce064@charusat.edu.in";
    private final String USERNAME = "harshil_sp";
    private final String PASSWORD = "20ce064";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FullName = findViewById(R.id.editFullName);
        UserName = findViewById(R.id.editUsername);
        Email = findViewById(R.id.editEmail);
        Password = findViewById(R.id.editPassword);

        BtnSubmit = findViewById(R.id.SubmitBtn);

        BtnSubmit.setOnClickListener(view -> {
            if (Email.getText().toString().equals(EMAIL) && UserName.getText().toString().equals(USERNAME)) {
                if (Password.getText().toString().equals(PASSWORD)) {
                    Intent i = new Intent(MainActivity.this, DetailsActivity.class);
                    i.putExtra("USERNAME", UserName.getText().toString());
                    i.putExtra("FullName", FullName.getText().toString());
                    i.putExtra("EMAIL", Email.getText().toString());
                    i.putExtra("Password", Password.getText().toString());
                    startActivity(i);
                } else
                    Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Invalid Email or Username", Toast.LENGTH_SHORT).show();
            }
        });
    }
}