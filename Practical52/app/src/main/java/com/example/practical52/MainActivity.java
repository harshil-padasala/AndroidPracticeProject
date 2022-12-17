package com.example.practical52;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<OSModel> osList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        osList.add(new OSModel(R.drawable.android, "Android", ""));
        osList.add(new OSModel(R.drawable.apple, "MAC OS", ""));
        osList.add(new OSModel(R.drawable.windows, "Windows", ""));
        osList.add(new OSModel(R.drawable.centos, "CentOS", ""));
        osList.add(new OSModel(R.drawable.debian, "Debian", ""));
        osList.add(new OSModel(R.drawable.fedora, "Fedora", ""));
        osList.add(new OSModel(R.drawable.kalilinux, "Kali Linux", ""));
        osList.add(new OSModel(R.drawable.linux, "Linux", ""));
        osList.add(new OSModel(R.drawable.ubuntu, "Ubuntu", ""));
        osList.add(new OSModel(R.drawable.redhat, "Red Hat", ""));


        OSModelAdapter osModelAdapter = new OSModelAdapter(MainActivity.this, osList);
        recyclerView.setAdapter(osModelAdapter);
    }
}