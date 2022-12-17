package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnFragA, btnFragB, btnFragC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragA = findViewById(R.id.fragmentA);
        btnFragB = findViewById(R.id.fragmentB);
        btnFragC = findViewById(R.id.fragmentC);

        FragmentTransaction ftr = getSupportFragmentManager().beginTransaction();

        ftr.add(R.id.container, new AboveFragment());
        ftr.commit();

        btnFragA.setOnClickListener(view -> {

            // for androidx Fragment
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            ft.replace(R.id.container, new AboveFragment());
            ft.commit();

        });

        btnFragB.setOnClickListener(view -> {

            // for androidx Fragment
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            ft.replace(R.id.container, new MidFragment());
            ft.commit();

        });

        btnFragC.setOnClickListener(view -> {

            // for androidx Fragment
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            ft.replace(R.id.container, new BelowFragment());
            ft.commit();

        });
    }
}