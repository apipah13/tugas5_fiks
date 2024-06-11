package com.example.gabungan_mmprog;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity13 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);

        ImageView lk2 = findViewById(R.id.lk2);

        lk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Panggil fungsi untuk memulai animasi rotasi acak
                startRandomRotation(lk2);
            }
        });
    }
    private void startRandomRotation(ImageView imageView) {
        Random random = new Random();
        float startAngle = imageView.getRotation(); // Mulai dari sudut saat ini
        float endAngle = startAngle + random.nextInt(360);  // Akhiri pada sudut acak
        long duration = random.nextInt(2000) + 1000;  // Durasi antara 1000ms dan 3000ms

        ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(imageView, "rotation", startAngle, endAngle);
        rotateAnimator.setDuration(duration);  // Durasi acak
        rotateAnimator.start();
    }

}