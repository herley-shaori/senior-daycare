package com.example.alenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LansiaPlaceServiceSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lansia_place_service_selection);

        setTitleImage();
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
        }else if(namaTempat.equals("Panti Jompo Waluya Sejati Abadi")){
            imageView.setImageResource(R.drawable.waluya_lansia);
        }
    }
}