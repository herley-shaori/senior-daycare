package com.example.alenapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar supportActionBar = this.getSupportActionBar();
        // Action bar icon.
        supportActionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_action_bar_images, null);
        supportActionBar.setCustomView(view);

        // Action bar background color.
        supportActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        setContentView(R.layout.activity_main);
    }
}