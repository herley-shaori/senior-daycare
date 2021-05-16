package com.example.alenapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailBookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_booking);

        actionBarCustomTitle("Detail Pesanan");
        findViewById(R.id.pesanKonfirmasiPembayaran).setOnClickListener(v -> {
            Intent intent = new Intent(DetailBookingActivity.this, ReviewBookingActivity.class);
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