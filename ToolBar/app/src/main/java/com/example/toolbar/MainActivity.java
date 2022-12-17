package com.example.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.StatusBarManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if we are using android.widget.Toolbar then use
        // setActionBar();

        // step 1
        // if we are using androidx.appcompat.widget.Toolbar then use
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // step 2
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My Title");
        // toolbar.setTitle("My Title");               // low priority didn't work
        toolbar.setSubtitle("My SubTitle");

//        Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.options_new1){
            Toast.makeText(this, "vgyhbnjuikm1", Toast.LENGTH_LONG).show();
        }
        else if(itemId == R.id.options_new2) {
            Toast.makeText(this, "vgyhbnjuikm2", Toast.LENGTH_LONG).show();
        }
        else if (itemId == R.id.options_new3) {
            Toast.makeText(this, "vgyhbnjuikm3", Toast.LENGTH_LONG).show();
        }
        else if (itemId == android.R.id.home){
            Toast.makeText(this, "bye", Toast.LENGTH_LONG).show();
            super.onBackPressed();
        }
        // find the id of back button android.R.id.home

        return super.onOptionsItemSelected(item);
    }

}