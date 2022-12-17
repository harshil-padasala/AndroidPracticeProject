package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtView = findViewById(R.id.textView);

        Button btnMove = findViewById(R.id.btnMove);
        Button btnRotate = findViewById(R.id.btnRotate);
        Button btnScale = findViewById(R.id.btnScale);
        Button btnAlpha = findViewById(R.id.btnAlpha);

        btnMove.setOnClickListener(view -> {
            Animation moveAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
            txtView.startAnimation(moveAnim);
        });

        btnAlpha.setOnClickListener(view -> {
            Animation alphaAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
            txtView.startAnimation(alphaAnim);
        });
        btnRotate.setOnClickListener(view -> {
            Animation rotateAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
            txtView.startAnimation(rotateAnim);
        });
        btnScale.setOnClickListener(view -> {
            Animation scaleAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
            txtView.startAnimation(scaleAnim);
        });

    }
}