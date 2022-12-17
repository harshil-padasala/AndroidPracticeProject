package com.example.recyclerview;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    FloatingActionButton btnOpenDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,
                new ArrayList<String>());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrContacts.add(new ContactModel(R.drawable.a, "Krishna Golkaiya", "CGPA: 10.00, SGPA: 10.00"));
        arrContacts.add(new ContactModel(R.drawable.b, "Harshil Padasala", "CGPA: 9.00, SGPA: 9.00"));
        arrContacts.add(new ContactModel(R.drawable.c, "Dhey Padasala", "CGPA: 8.00, SGPA: 8.00"));
        arrContacts.add(new ContactModel(R.drawable.d, "Hasti Padasala", "CGPA: 10.00, SGPA: 10.00"));
        arrContacts.add(new ContactModel(R.drawable.e, "Harshil Padasala", "CGPA: 9.00, SGPA:9 .00"));
        arrContacts.add(new ContactModel(R.drawable.f, "Rutik Vasani", "CGPA: 7.00, SGPA: 7.00"));
        arrContacts.add(new ContactModel(R.drawable.g, "Hemil Kevadiya", "CGPA: 6.00, SGPA: 6.00"));
        arrContacts.add(new ContactModel(R.drawable.h, "Harshil Padasala", "CGPA: 5.00, SGPA: 5.00"));
        arrContacts.add(new ContactModel(R.drawable.i, "Henil Mistry", "CGPA: 4.00, SGPA: 4.00"));
        arrContacts.add(new ContactModel(R.drawable.a, "Kuldeep Korat", "CGPA: 3.00, SGPA: 3.00"));
        arrContacts.add(new ContactModel(R.drawable.b, "Uttam Bhavani", "CGPA: 2.00, SGPA: 2.00"));
        arrContacts.add(new ContactModel(R.drawable.c, "Om Sorathiya", "CGPA: 1.00, SGPA: 1.00"));

        RecyclerContactAdapter recyclerContactAdapter =
                new RecyclerContactAdapter(MainActivity.this, arrContacts);

        recyclerView.setAdapter(recyclerContactAdapter);

        btnOpenDialog = findViewById(R.id.btnOpenDialog);
        btnOpenDialog.setOnClickListener(view -> {

            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.add_update_layout);

            EditText edtContactName = dialog.findViewById(R.id.edtContactName);
            EditText edtContactNumber = dialog.findViewById(R.id.edtContactNumber);
            Button btnSubmit = dialog.findViewById(R.id.submit_button);

            btnSubmit.setOnClickListener(view1 -> {

                String contactName = "";
                String contactNumber = "";

                if (!edtContactName.getText().toString().equals("") && !edtContactNumber.getText().toString().equals("")) {
                    contactName = edtContactName.getText().toString();
                    contactNumber = edtContactNumber.getText().toString();

                    arrContacts.add(new ContactModel(contactName, contactNumber));
                    recyclerContactAdapter.notifyItemInserted(arrContacts.size() - 1);
                    recyclerView.scrollToPosition(arrContacts.size() - 1);
                    dialog.dismiss();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter valid details", Toast.LENGTH_LONG).show();
                }


            });
            dialog.show();
        });

    }

    public String randomNumber() {
        String number = "";
        for (int i = 0; i < 10; i++) {
            number += (Integer.toString((int) (Math.random() * 10)));
        }
        return number;
    }
}