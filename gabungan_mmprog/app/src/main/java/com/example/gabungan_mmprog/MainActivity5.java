package com.example.gabungan_mmprog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import android.widget.LinearLayout;
import android.content.SharedPreferences;

public class MainActivity5 extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_SCORE = "score";

    private TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ImageView drawer_apa = findViewById(R.id.drawer_apa);
        scoreTextView = findViewById(R.id.scoreTextView);


        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int score = sharedPreferences.getInt(KEY_SCORE, 30);  // Default score is 30
        scoreTextView.setText(String.valueOf(score));

        drawer_apa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer();
            }
        });
    }
    private void openDrawer() {
        DrawerLayout drawerLayout = findViewById(R.id.drawerlayout);
        drawerLayout.openDrawer(GravityCompat.END);

    }


    public void scan(View view) {
        Intent intent = new Intent(MainActivity5.this,MainActivity7.class);
        startActivity(intent);
    }

    public void redeem(View view) {
        Intent intent = new Intent(MainActivity5.this,MainActivity9.class);
        startActivity(intent);
    }

    public void ekstra(View view) {
        Intent intent = new Intent(MainActivity5.this,MainActivity11.class);
        startActivity(intent);
    }

    public void royal(View view) {
        Intent intent = new Intent(MainActivity5.this,MainActivity13.class);
        startActivity(intent);
    }
}