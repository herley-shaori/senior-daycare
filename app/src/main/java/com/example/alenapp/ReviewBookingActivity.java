package com.example.alenapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ReviewBookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_booking);

        actionBarCustomTitle("Konfirmasi Pesanan dan Pembayaran");
        findViewById(R.id.tombolTotalKonfirmasi).setOnClickListener(v -> {
            Intent intent = new Intent(ReviewBookingActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    /**
     * Custom bar custom title.
     * @param actionBarTitle
     */
    private void actionBarCustomTitle(String actionBarTitle) {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        TextView textView = findViewById(R.id.tvTitleActionBar);
        textView.setText(actionBarTitle);
    }
}