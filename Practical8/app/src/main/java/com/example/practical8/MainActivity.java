package com.example.practical8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextInputEditText emailTo, emailSubject, emailMessage;
    Button sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailTo = findViewById(R.id.email_to);
        emailSubject = findViewById(R.id.email_subject);
        emailMessage = findViewById(R.id.email_message);

        sendEmail = findViewById(R.id.send_email);

        sendEmail.setOnClickListener(view -> {
            Intent intentSendEmail = new Intent(Intent.ACTION_SEND);
            intentSendEmail.setType("message/rfc822");

            intentSendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"harshilpadsala@gmail.com", String.valueOf(emailTo.getText())});
            intentSendEmail.putExtra(Intent.EXTRA_CC, new String[] {"20ce054@charusat.edu.in"});
            intentSendEmail.putExtra(Intent.EXTRA_SUBJECT, Objects.requireNonNull(emailSubject.getText()).toString());
            intentSendEmail.putExtra(Intent.EXTRA_TEXT, Objects.requireNonNull(emailMessage.getText()).toString());

            startActivity(Intent.createChooser(intentSendEmail, "Email Via: "));
        });


    }
}