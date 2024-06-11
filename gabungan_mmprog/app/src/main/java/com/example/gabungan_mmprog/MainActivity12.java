package com.example.gabungan_mmprog;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        // Cari ImageView dari layout
        ImageView lk1 = findViewById(R.id.lk1);

        // Set OnClickListener untuk lk1
        lk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Panggil fungsi untuk memulai animasi rotasi acak
                startRandomRotation(lk1);
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

    public void backhome5(View view) {
        Intent intent = new Intent(MainActivity12.this, MainActivity5.class);
        startActivity(intent);
    }

    public void ektraredem(View view) {
        Intent intent = new Intent(MainActivity12.this, MainActivity6.class);
        startActivity(intent);
    }
}
