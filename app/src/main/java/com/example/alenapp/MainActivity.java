package com.example.alenapp;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;

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

        // Button action handler.
        AppCompatButton buttonGo = findViewById(R.id.go_button);
        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_select_lansia_place();
            }
        });

        findViewById(R.id.senior_daycare).setOnClickListener(actionNotAvailable());
        findViewById(R.id.antar_jemput).setOnClickListener(actionNotAvailable());
        findViewById(R.id.event).setOnClickListener(actionNotAvailable());
        findViewById(R.id.home).setOnClickListener(actionNotAvailable());
        findViewById(R.id.my_order).setOnClickListener(actionNotAvailable());
        findViewById(R.id.elite_rewards).setOnClickListener(actionNotAvailable());

        // Daycare schedule button handler.
        this.dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        this.tvDateResult = findViewById(R.id.daycare_date);
        AppCompatButton buttonPickADate = findViewById(R.id.date_button);
        buttonPickADate.setOnClickListener(v -> shorDateCalendarDialog());
    }

    /**
     * Melihat daftar tempat perawatan lansia.
     */
    private void start_select_lansia_place() {
        Intent switchActivityIntent = new Intent(MainActivity.this, SelectLansiaPlace.class);
        startActivity(switchActivityIntent);
    }

    /**
     * Tombol aksi implementasi fitur belum tersedia.
     * @return
     */
    private View.OnClickListener actionNotAvailable() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Fitur belum tersedia.",
                        Toast.LENGTH_LONG).show();
            }
        };
    }

    /**
     * Tampilkan tanggal.
     */
    private void shorDateCalendarDialog() {
        /**
         * Calendar untuk mendapatkan tanggal sekarang
         */
        Calendar newCalendar = Calendar.getInstance();

        /**
         * Initiate DatePicker dialog
         */
        datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                /**
                 * Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
                 */

                /**
                 * Set Calendar untuk menampung tanggal yang dipilih
                 */
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                /**
                 * Update TextView dengan tanggal yang kita pilih
                 */
                tvDateResult.setText(dateFormatter.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        /**
         * Tampilkan DatePicker dialog
         */
        datePickerDialog.show();
    }
}