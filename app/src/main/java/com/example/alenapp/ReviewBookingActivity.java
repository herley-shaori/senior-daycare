package com.example.alenapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.properties.Person;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ReviewBookingActivity extends AppCompatActivity {
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_booking);

        this.person = this.getIntent().getParcelableExtra("person");

        actionBarCustomTitle("Konfirmasi Pesanan dan Pembayaran");
        findViewById(R.id.tombolTotalKonfirmasi).setOnClickListener(v -> {
            Intent intent = new Intent(ReviewBookingActivity.this, MainActivity.class);

            Toast.makeText(ReviewBookingActivity.this, "Pembayaran telah diterima.",
                    Toast.LENGTH_LONG).show();

            startActivity(intent);
        });

        int hargaMakanan = this.person.getFood().getHargaTotalFood() * this.person.getLocation().getLengthOfStay();
        TextView textViewMakanan = findViewById(R.id.isiMakanan);
        textViewMakanan.setText("Rp. "+moneyFormatter(hargaMakanan));

        int hargaSnack = this.person.getSnack().getHargaTotalSnack() * this.person.getLocation().getLengthOfStay();
        TextView textViewSnack = findViewById(R.id.isiSnack);
        textViewSnack.setText("Rp. "+moneyFormatter(hargaSnack));

        int hargaTransport = this.person.getMobileTransport().getTotalHargaMobileTransport();
        TextView textViewTransport = findViewById(R.id.isiTransport);
        textViewTransport.setText("Rp. "+moneyFormatter(hargaTransport));

        int hargaLokasi = this.person.getLocation().getTotalHargaLocation() * this.person.getLocation().getLengthOfStay();
        TextView textViewLokasi = findViewById(R.id.isiTeksHargaLokasi);
        textViewLokasi.setText("Rp. "+moneyFormatter(hargaLokasi));

        TextView textViewHargaTotal = findViewById(R.id.isiTeksHargaTotal);
        textViewHargaTotal.setText(moneyFormatter(hargaMakanan+hargaSnack+hargaTransport+hargaLokasi));
    }

    /**
     * Money formatter.
     * @param uang
     * @return
     */
    private String moneyFormatter(int uang){
        NumberFormat formatter = new DecimalFormat("#,###");
        return formatter.format(uang);
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