package com.example.practical11;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TextInputEditText name, contact, dob;
    Button insert, update, delete, view;
    Helper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        dob = findViewById(R.id.dob);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new Helper(this);
        insert.setOnClickListener(view -> {
            String nameTXT = Objects.requireNonNull(name.getText()).toString();
            String contactTXT = Objects.requireNonNull(contact.getText()).toString();
            String dobTXT = Objects.requireNonNull(dob.getText()).toString();
            Boolean checkpoints = DB.insertuserdata(nameTXT, contactTXT, dobTXT);
            if (checkpoints)
                Toast.makeText(MainActivity.this, "New Entry Inserted",
                        Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this, "New Entry Not Inserted",
                        Toast.LENGTH_SHORT).show();
        });
        update.setOnClickListener(view -> {
            String nameTXT = Objects.requireNonNull(name.getText()).toString();
            String contactTXT = Objects.requireNonNull(contact.getText()).toString();
            String dobTXT = Objects.requireNonNull(dob.getText()).toString();
            Boolean checkmated = DB.updateuserdata(nameTXT, contactTXT, dobTXT);
            if (checkmated)
                Toast.makeText(MainActivity.this, "Entry Updated",
                        Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this, "New Entry Not Updated",
                        Toast.LENGTH_SHORT).show();
        });
        delete.setOnClickListener(view -> {
            String nameTXT = Objects.requireNonNull(name.getText()).toString();
            Boolean checkDeleteData = DB.deletedata(nameTXT);
            if (checkDeleteData)
                Toast.makeText(MainActivity.this, "Entry Deleted",
                        Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this, "Entry Not Deleted",
                        Toast.LENGTH_SHORT).show();
        });
        view.setOnClickListener(view -> {
            Cursor res = DB.getdata();
            if (res.getCount() == 0) {
                Toast.makeText(MainActivity.this, "No Entry Exists",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            StringBuilder buffer = new StringBuilder();
            while (res.moveToNext()) {
                buffer.append("Name :").append(res.getString(0)).append("\n");
                buffer.append("Contact :").append(res.getString(1)).append("\n");
                buffer.append("Date of Birth :").append(res.getString(2)).append("\n\n");
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setCancelable(true);
            builder.setTitle("User Entries");
            builder.setMessage(buffer.toString());
            builder.show();
        });
    }
}
