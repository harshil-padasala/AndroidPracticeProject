package com.example.galleryview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;

public class MainActivity extends AppCompatActivity {

    Gallery simpleGallery;

    CustomizedGalleryAdapter customGalleryAdapter;

    ImageView image;

    int[] images = {R.drawable.c, R.drawable.csharp, R.drawable.css, R.drawable.js, R.drawable.r,
            R.drawable.html5, R.drawable.java, R.drawable.python, R.drawable.mysql, R.drawable.postgre,
            R.drawable.kotlinlogo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleGallery = (Gallery) findViewById(R.id.languagesGallery);
        image = (ImageView) findViewById(R.id.imageView);


        customGalleryAdapter = new CustomizedGalleryAdapter(getApplicationContext(), images);

        simpleGallery.setAdapter(customGalleryAdapter);

        simpleGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Whichever image is clicked, that is set in the  selectedImageView
                // position will indicate the location of image
                image.setImageResource(images[position]);
            }
        });

    }
}