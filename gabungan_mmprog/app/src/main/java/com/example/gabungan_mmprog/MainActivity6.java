package com.example.gabungan_mmprog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
import android.Manifest;
import android.content.pm.PackageManager;
import android.provider.MediaStore;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;
import android.net.Uri;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
public class MainActivity6 extends AppCompatActivity {
    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int CAMERA_REQUEST_CODE = 101;
    private ImageView imageView;

    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_SCORE = "score";

    private TextView scoreTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        scoreTextView = findViewById(R.id.scoreTextView);


        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int score = sharedPreferences.getInt(KEY_SCORE, 30);  // Default score is 30
        scoreTextView.setText(String.valueOf(score));

        // Inisialisasi ImageView
        imageView = findViewById(R.id.imageView);
    }

    public void backhome(View view) {
        Intent intent = new Intent(MainActivity6.this, MainActivity5.class);
        startActivity(intent);
    }

    public void camera(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
        } else {
            // Lakukan tindakan jika izin telah diberikan
            openCamera();
        }
    }

    private void openCamera() {
        // Buat Intent untuk membuka aplikasi kamera bawaan
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Periksa apakah ada aplikasi kamera yang dapat menangani permintaan ini
        if (cameraIntent.resolveActivity(getPackageManager()) != null) {
            // Mulai aktivitas kamera dan tunggu hasilnya
            startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
        } else {
            // Tampilkan pesan jika tidak ada aplikasi kamera yang ditemukan
            Toast.makeText(this, "No camera app found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Izin diberikan, lakukan tindakan
                openCamera();
            } else {
                // Izin ditolak, lakukan sesuatu, misalnya tampilkan pesan
                Toast.makeText(this, "Camera permission denied.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            // Ambil gambar dari intent hasil
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            // Set gambar ke ImageView
            imageView.setImageBitmap(imageBitmap);
        }
    }

    public void cancel(View view) {
        Intent intent = new Intent(MainActivity6.this, MainActivity12.class);
        startActivity(intent);
    }
}