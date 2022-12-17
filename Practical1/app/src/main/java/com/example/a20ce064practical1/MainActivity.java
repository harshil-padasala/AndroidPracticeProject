package com.example.a20ce064practical1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupHyperlink();
    }

    public void setupHyperlink() {
        TextView linkTextView = findViewById(R.id.hyperlink_charusat);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}