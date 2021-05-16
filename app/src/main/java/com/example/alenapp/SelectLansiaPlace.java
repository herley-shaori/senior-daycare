package com.example.alenapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.properties.Person;

public class SelectLansiaPlace extends AppCompatActivity {

    int images[] = {R.drawable.citra_lansia, R.drawable.waluya_lansia};
    String namaTempat[] = {"Citra Premier Luxury Seniors Clubhouse", "Panti Jompo Waluya Sejati Abadi"};
    String lokasi[] = {"Jakarta", "Jakarta"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_lansia_place);

        String actionBarTitle = "Pilihan Lokasi Rawat Lansia";
        actionBarCustomTitle(actionBarTitle);

        Person person = this.getIntent().getParcelableExtra("person");

        System.out.println(person);
        System.out.println("Sukses Parcel.");

        listViewStarter();
    }

    /**
     * Custombar custom title.
     * @param actionBarTitle
     */
    private void actionBarCustomTitle(String actionBarTitle) {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        TextView textView = findViewById(R.id.tvTitleActionBar);
        textView.setText(actionBarTitle);
    }

    /**
     * ListView starter.
     */
    private void listViewStarter() {
        ListView listView = findViewById(R.id.daycarePlaceDetail);
        listView.setAdapter(new ListCustomAdapter());
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent switchActivityIntent = new Intent(SelectLansiaPlace.this, LansiaPlaceServiceSelection.class);
            switchActivityIntent.putExtra("namaTempat", namaTempat[position]);
            startActivity(switchActivityIntent);
        });
    }

    /**
     * Custom Adapter.
     */
    class ListCustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = getLayoutInflater().inflate(R.layout.item, null);

            ImageView imageView = v.findViewById(R.id.itemImage);
            TextView judulLokasiTv = v.findViewById(R.id.namaTempat);
            TextView lokasiTv = v.findViewById(R.id.lokasi);
            TextView hargaTv = v.findViewById(R.id.harga);
            TextView sisaTv = v.findViewById(R.id.sisa);

            imageView.setImageResource(images[position]);
            judulLokasiTv.setText(namaTempat[position]);
            lokasiTv.setText(lokasi[position]);

            setHargaDaycareSetiapHari(position, hargaTv);
            setSisaSetiapPemesanan(position, sisaTv);
            return v;
        }
    }

    /**
     * Layanan tersedia.
     * @param position
     * @param sisaTv
     */
    private void setSisaSetiapPemesanan(int position, TextView sisaTv) {
        switch (position){
            case 0:
                sisaTv.setText("Tersisa: "+ Constant.SISA_LUXURY+" slot.");
                break;
            case 1:
                sisaTv.setText("Tersisa: "+Constant.SISA_WALUYA+" slot.");
                break;
        }
    }

    /**
     * Set harga dayCare setiap hari.
     * @param position
     * @param hargaTv
     */
    private void setHargaDaycareSetiapHari(int position, TextView hargaTv) {
        switch (position){
            case 0:
                hargaTv.setText("Mulai "+"Rp. "+"250.000"+" per hari.");
                break;
            case 1:
                hargaTv.setText("Mulai "+"Rp. "+"250.000"+" per hari.");
                break;
        }
    }
}