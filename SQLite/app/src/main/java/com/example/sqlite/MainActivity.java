package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBaseHelper dbHelper = new DataBaseHelper(this);

//        dbHelper.addContact("Harry", "9087654321");
//        dbHelper.addContact("Jerry", "9087654321");
//        dbHelper.addContact("Monty", "9087654321");
//        dbHelper.addContact("John", "9087654321");
//        dbHelper.addContact("Robert", "9087654321");
//        dbHelper.addContact("Elis", "9087654321");
//        dbHelper.addContact("Mia", "9087654321");
//        dbHelper.addContact("Johny", "9087654321");
//

        ArrayList<ContactModel> arrContacts = dbHelper.fetchContacts();

        for (int i = 0; i < arrContacts.size(); i++) {
            Log.d("CONTACT_INFO" , "Name: " + arrContacts.get(i).name + ", Phone Number: " + arrContacts.get(i).phoneNumber);
        }
    }
}