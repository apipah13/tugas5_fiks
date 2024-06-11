package com.example.gabungan_mmprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity9 extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_SCORE = "score";

    private TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
            scoreTextView = findViewById(R.id.scoreTextView);

            SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
            int score = sharedPreferences.getInt(KEY_SCORE, 30);  // Default score is 30
            scoreTextView.setText(String.valueOf(score));
    }

    public void backhome3(View view) {
        Intent intent = new Intent(MainActivity9.this,MainActivity5.class);
        startActivity(intent);
    }

    public void kereedem(View view) {
        Intent intent = new Intent(MainActivity9.this,MainActivity10.class);
        startActivity(intent);
    }
}