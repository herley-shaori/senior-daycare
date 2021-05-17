package com.example.alenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.properties.Location;
import com.properties.Person;

public class LansiaPlaceServiceSelection extends AppCompatActivity {
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lansia_place_service_selection);

        this.person = this.getIntent().getParcelableExtra("person");

        System.out.println("Location: "+this.person.getLocation().getLocation());
        System.out.println("Date: "+this.person.getDaycareDate());

        setTitleImage();
        startADetailedActivity();
    }

    /**
     * Start detailed booking activity.
     */
    private void startADetailedActivity() {
        Intent switchActivityIntent = new Intent(LansiaPlaceServiceSelection.this, DetailBookingActivity.class);
        findViewById(R.id.tombolLayananSatu).setOnClickListener(v -> startActivity(switchActivityIntent));
        findViewById(R.id.tombolLayananDua).setOnClickListener(v -> startActivity(switchActivityIntent));
        findViewById(R.id.tombolLayananTiga).setOnClickListener(v -> startActivity(switchActivityIntent));
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

    /**
     * Set title image according to user selection.
     */
    private void setTitleImage() {
        ImageView imageView = findViewById(R.id.titleImageLansiaPlaceServiceSelection);
        Intent previousIntent = this.getIntent();
        String namaTempat = previousIntent.getStringExtra("namaTempat");
        if(namaTempat.equals("Citra Premier Luxury Seniors Clubhouse")){
            imageView.setImageResource(R.drawable.citra_lansia);
            actionBarCustomTitle("Citra Premier Luxury Seniors Clubhouse");
        }else if(namaTempat.equals("Panti Jompo Waluya Sejati Abadi")){
            imageView.setImageResource(R.drawable.waluya_lansia);
            actionBarCustomTitle("Panti Jompo Waluya Sejati Abadi");
        }
    }
}