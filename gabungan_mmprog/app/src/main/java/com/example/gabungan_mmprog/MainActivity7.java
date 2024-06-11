package com.example.gabungan_mmprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity7 extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_SCORE = "score";

    private int score;
    private TextView pointTextView;
    private Button scanButton, submitButton;
    private ImageView claimImageView1, claimImageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        pointTextView = findViewById(R.id.pointTextView);
        scanButton = findViewById(R.id.qrscan);
        submitButton = findViewById(R.id.submit);
        claimImageView1 = findViewById(R.id.claimImageView1); // First ImageView for claim indication
        claimImageView2 = findViewById(R.id.claimImageView2); // Second ImageView for claim indication

        // Load score from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        score = sharedPreferences.getInt(KEY_SCORE, 30);  // Default score is 30
        pointTextView.setText(String.valueOf(score));

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start QR code scanning
                startQRCodeScanning();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save the score before navigating to the next activity
                saveScore(score);
                // Navigate to the next activity
                goToMainActivity();
            }
        });
    }

    private void startQRCodeScanning() {
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        intentIntegrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                // Handle the case where no QR code was found (scan canceled)
                Toast.makeText(this, "Tidak ada QR code yang ditemukan", Toast.LENGTH_SHORT).show();
            } else {
                // QR code was successfully scanned
                addScore(10); // Add 10 points for each successful scan
                Toast.makeText(this, "Klaim tutup botol Anda di sini", Toast.LENGTH_SHORT).show();
                // Set visibility of claimImageView1 and claimImageView2 to VISIBLE
                claimImageView1.setVisibility(View.VISIBLE);
                claimImageView2.setVisibility(View.VISIBLE);
            }
        }
    }

    private void addScore(int value) {
        score += value;
        pointTextView.setText(String.valueOf(score));
    }

    private void saveScore(int score) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_SCORE, score);
        editor.apply();
    }

    private void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity8.class);
        startActivity(intent);
        finish();
    }

    public void backhome2(View view) {
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);

    }
}
