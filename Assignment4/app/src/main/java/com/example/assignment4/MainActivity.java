package com.example.assignment4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout1;
    private LottieAnimationView lottie;

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout1=findViewById(R.id.layout1);
        lottie = findViewById(R.id.lottie);

        list = findViewById(R.id.listview);

        Student student1 = new Student("Krishna", "10.0", "10.0");
        Student student2 = new Student("Hasti", "10.0", "10.0");
        Student student3 = new Student("Harshil", "9.0", "9.0");
        Student student4 = new Student("Dhey", "8.0", "8.0");
        Student student5 = new Student("Hemil", "7.0", "7.0");
        Student student6 = new Student("Rutik", "6.0", "6.0");
        Student student7 = new Student("Henil", "5.0", "5.0");
        Student student8 = new Student("Kuldeep", "4.0", "4.0");
        Student student9 = new Student("Uttam", "3.0", "3.0");
        Student student10 = new Student("Om", "2.0", "2.0");


        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(student1);
        arrayList.add(student2);
        arrayList.add(student3);
        arrayList.add(student4);
        arrayList.add(student5);
        arrayList.add(student6);
        arrayList.add(student7);
        arrayList.add(student8);
        arrayList.add(student9);
        arrayList.add(student10);

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int i=item.getItemId();
        switch (i) {
            case R.id.red:
                layout1.setBackgroundColor(getResources().getColor(R.color.red));
                lottie.setAnimation(R.raw.red);
                break;
            case R.id.purple:
                layout1.setBackgroundColor(getResources().getColor(R.color.purple_200));
                lottie.setAnimation(R.raw.purple);
                break;
            case R.id.blue:
                layout1.setBackgroundColor(getResources().getColor(R.color.blue));
                lottie.setAnimation(R.raw.blue);
                break;
            case R.id.yellow:
                layout1.setBackgroundColor(getResources().getColor(R.color.yellow));
                lottie.setAnimation(R.raw.yellow);
                break;
            case R.id.green:
                layout1.setBackgroundColor(getResources().getColor(R.color.green));
                lottie.setAnimation(R.raw.green);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}