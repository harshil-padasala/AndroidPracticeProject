package com.example.a20ce064assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setHyperlink();
    }

    private void setHyperlink() {
        TextView linkTextView = findViewById(R.id.hyperlink_company);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}