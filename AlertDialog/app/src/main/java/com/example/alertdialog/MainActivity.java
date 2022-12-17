package com.example.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Alert Dialog");
        toolbar.setSubtitle("Practice");

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder twoBtnDialog = new AlertDialog.Builder(MainActivity.this);
        twoBtnDialog.setTitle("Exit");
        twoBtnDialog.setIcon(R.drawable.ic_baseline_exit_to_app_24);
        twoBtnDialog.setMessage("Do you want to exit?");

        twoBtnDialog.setPositiveButton("Yes", (dialogInterface, i) -> {
            Toast.makeText(MainActivity.this, "Exited Successfully", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        });

        twoBtnDialog.setNegativeButton("No", (dialogInterface, i) -> Toast.makeText(MainActivity.this, "Sexyyyy", Toast.LENGTH_SHORT).show());

        twoBtnDialog.setNeutralButton("Cancel", (dialogInterface, i) -> Toast.makeText(MainActivity.this, "Sexyyyy", Toast.LENGTH_SHORT).show());

        twoBtnDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(getApplicationContext()).inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.options_new1) {
//            Toast.makeText(MainActivity.this, "Sexyyyy", Toast.LENGTH_SHORT).show();
            alertTwoSingleButton();
        } else if (itemId == R.id.options_new2) {
//            Toast.makeText(MainActivity.this, "Sexyyyy", Toast.LENGTH_SHORT).show();
            alertSingleButton(DialogInterface.BUTTON_NEGATIVE);
        } else if (itemId == R.id.options_new3) {
//            Toast.makeText(MainActivity.this, "Sexyyyy", Toast.LENGTH_SHORT).show();
            alertThreeSingleButton();
        } else if (itemId == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    private void alertSingleButton(int whichButton) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        alertDialog.setTitle("Terms ans Conditions");
        alertDialog.setIcon(R.drawable.ic_baseline_warning_24);
        alertDialog.setMessage("Have you read every T & C ?");

        alertDialog.setButton(whichButton, "Yes",
                (dialogInterface, i) -> Toast.makeText(MainActivity.this, "Sexyyyy", Toast.LENGTH_SHORT).show());

        alertDialog.show();
    }

    private void alertTwoSingleButton() {
        AlertDialog.Builder twoBtnDialog = new AlertDialog.Builder(MainActivity.this);
        twoBtnDialog.setTitle("Delete");
        twoBtnDialog.setIcon(R.drawable.ic_baseline_delete_24);
        twoBtnDialog.setMessage("Do you want to delete it permanently?");

        twoBtnDialog.setPositiveButton("Yes", (dialogInterface, i) -> Toast.makeText(MainActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show());

        twoBtnDialog.setNegativeButton("No", (dialogInterface, i) -> Toast.makeText(MainActivity.this, "No Deleted", Toast.LENGTH_SHORT).show());

        twoBtnDialog.show();
    }

    private void alertThreeSingleButton() {
        AlertDialog.Builder twoBtnDialog = new AlertDialog.Builder(MainActivity.this);
        twoBtnDialog.setTitle("Exit");
        twoBtnDialog.setIcon(R.drawable.ic_baseline_exit_to_app_24);
        twoBtnDialog.setMessage("Do you want to exit?");

        twoBtnDialog.setPositiveButton("Yes", (dialogInterface, i) -> {
            Toast.makeText(MainActivity.this, "Exited Successfully", Toast.LENGTH_SHORT).show();
            MainActivity.super.onBackPressed();
            ;
        });

        twoBtnDialog.setNegativeButton("No", (dialogInterface, i) -> Toast.makeText(MainActivity.this, "No Deleted", Toast.LENGTH_SHORT).show());

        twoBtnDialog.setNeutralButton("Cancel", (dialogInterface, i) -> Toast.makeText(MainActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show());

        twoBtnDialog.show();
    }

}