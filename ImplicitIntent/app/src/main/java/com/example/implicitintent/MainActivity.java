package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDial, btnMessage, btnEmail, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDial = findViewById(R.id.btnDial);
        btnMessage = findViewById(R.id.btnMessage);
        btnEmail = findViewById(R.id.btnEmail);
        btnShare = findViewById(R.id.btnShare);

        btnDial.setOnClickListener(view -> {
            // implicit intent passing
            Intent iDial = new Intent(Intent.ACTION_DIAL);
            // iDial.setAction(Intent.ACTION_DIAL);

            // passing the number
            // Uri means: Uniform resource identifier
            iDial.setData(Uri.parse("tel: +919099308680"));
            startActivity(iDial);

        });

        btnMessage.setOnClickListener(view -> {
            Intent iMessage = new Intent(Intent.ACTION_SENDTO);
            iMessage.setData(Uri.parse("smsto:"+Uri.parse("+917016363106")));
            iMessage.putExtra("sms_body", "Please, solve this problem");
            startActivity(iMessage);
        });

        btnEmail.setOnClickListener(view -> {
            Intent iEmail = new Intent(Intent.ACTION_SEND);
            iEmail.setType("message/rfc822");
            iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"harshilpadsala99@gmail.com", "20ce054@charusat.edu.in"});
            iEmail.putExtra(Intent.EXTRA_SUBJECT, "Practice");
            iEmail.putExtra(Intent.EXTRA_TEXT, "Please Practice this");
            startActivity(Intent.createChooser(iEmail, "Email via: "));
        });

        btnShare.setOnClickListener(view -> {
            Intent iShare = new Intent(Intent.ACTION_SEND);
            iShare.setType("text/plain");
            iShare.putExtra(Intent.EXTRA_TEXT, "Download this, ");
            startActivity(Intent.createChooser(iShare, "Share via: "));
        });
    }
}