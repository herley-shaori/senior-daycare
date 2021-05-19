package com.example.alenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.properties.Food;
import com.properties.Harga;
import com.properties.MobileTransport;
import com.properties.Person;
import com.properties.Snack;

public class DetailBookingActivity extends AppCompatActivity {
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_booking);

        this.person = this.getIntent().getParcelableExtra("person");

        Spinner lengthOfStaySpinner = findViewById(R.id.spinner2);
        lengthOfStaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Pengaman tombol.
                if(position == 0){
                    findViewById(R.id.pesanKonfirmasiPembayaran).setEnabled(false);
                }else{
                    findViewById(R.id.pesanKonfirmasiPembayaran).setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });;

        actionBarCustomTitle("Detail Pesanan");
        findViewById(R.id.pesanKonfirmasiPembayaran).setOnClickListener(v -> {

            Food food = foodConfig();
            Snack snack = snackConfig();
            this.person.getLocation().setTotalHargaLocation(lengthOfStaySpinner.getSelectedItemPosition()*this.person.getLocation().getHargaService());
            this.person.getLocation().setLengthOfStay(lengthOfStaySpinner.getSelectedItemPosition());

            MobileTransport mobileTransport = mobileTransportConfig();
            this.person.setFoodChoices(food);
            this.person.setSnackChoices(snack);
            this.person.setMobileTransport(mobileTransport);

            Intent intent = new Intent(DetailBookingActivity.this, ReviewBookingActivity.class);
            intent.putExtra("person", this.person);

            startActivity(intent);
        });

        listAdapterSetup();
    }

    /**
     * Mobile transport config.
     * @return
     */
    private MobileTransport mobileTransportConfig() {
        MobileTransport mobileTransport = new MobileTransport();
        Spinner spinnerTiga = findViewById(R.id.spinner3);
        if(spinnerTiga.getSelectedItemPosition() == 0){
            mobileTransport.setTotalHargaMobileTransport(Harga.FREED_TRANSPORT);
        }else if(spinnerTiga.getSelectedItemPosition() == 1){
            mobileTransport.setTotalHargaMobileTransport(Harga.INNOVA_TRANSPORT);
        }else if(spinnerTiga.getSelectedItemPosition() == 2){
            mobileTransport.setTotalHargaMobileTransport(Harga.MOBILIO_TRANSPORT);
        }
        return mobileTransport;
    }

    /**
     * Food config.
     * @return
     */
    private Food foodConfig() {
        Food food = new Food();
        RadioButton radioButtonSatu = findViewById(R.id.radioSatu);
        RadioButton radioButtonDua = findViewById(R.id.radioDua);
        int hargaTotalFood = 0;
        if(radioButtonSatu.isChecked()){
            hargaTotalFood += Harga.NASI_NOL;
        }

        if(radioButtonDua.isChecked()){
            hargaTotalFood += Harga.NASI_SATU;
        }
        food.setHargaTotalFood(hargaTotalFood);
        return food;
    }

    /**
     * Snack config.
     * @return
     */
    private Snack snackConfig() {
        RadioButton radioButtonTiga = findViewById(R.id.radioSnackSatu);
        RadioButton radioButtonEmpat = findViewById(R.id.radioSnackDua);
        RadioButton radioButtonLima = findViewById(R.id.radioSnackTiga);
        RadioButton radioButtonEnam = findViewById(R.id.radioSnackEmpat);

        Snack snack = new Snack();
        int hargaTotalSnack = 0;
        if(radioButtonTiga.isChecked()){
            hargaTotalSnack += Harga.SNACK_SATU;
        }
        if(radioButtonEmpat.isChecked()){
            hargaTotalSnack += Harga.SNACK_DUA;
        }
        if(radioButtonLima.isChecked()){
            hargaTotalSnack += Harga.SNACK_TIGA;
        }
        if(radioButtonEnam.isChecked()){
            hargaTotalSnack += Harga.SNACK_EMPAT;
        }

        snack.setHargaTotalSnack(hargaTotalSnack);
        return snack;
    }

    /**
     * Custom adapter setup.
     */
    private void listAdapterSetup() {
        ListView foodListView = findViewById(R.id.foodListView);
        foodListView.setAdapter(new FoodSelectionCustomAdapter());

        ListView snackListView = findViewById(R.id.snackListView);
        snackListView.setAdapter(new SnackSelectionCustomAdapter());
    }

    /**
     * Food selection custom adapter.
     */
    class FoodSelectionCustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 1;
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
            View v = getLayoutInflater().inflate(R.layout.food_choices, null);
            return v;
        }
    }

    /**
     * Snack selection ListAdapter.
     */
    class SnackSelectionCustomAdapter extends BaseAdapter {

        /**
         * How many items are in the data set represented by this Adapter.
         *
         * @return Count of items.
         */
        @Override
        public int getCount() {
            return 1;
        }

        /**
         * Get the data item associated with the specified position in the data set.
         *
         * @param position Position of the item whose data we want within the adapter's
         *                 data set.
         * @return The data at the specified position.
         */
        @Override
        public Object getItem(int position) {
            return null;
        }

        /**
         * Get the row id associated with the specified position in the list.
         *
         * @param position The position of the item within the adapter's data set whose row id we want.
         * @return The id of the item at the specified position.
         */
        @Override
        public long getItemId(int position) {
            return 0;
        }

        /**
         * Get a View that displays the data at the specified position in the data set. You can either
         * create a View manually or inflate it from an XML layout file. When the View is inflated, the
         * parent View (GridView, ListView...) will apply default layout parameters unless you use
         * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
         * to specify a root view and to prevent attachment to the root.
         *
         * @param position    The position of the item within the adapter's data set of the item whose view
         *                    we want.
         * @param convertView The old view to reuse, if possible. Note: You should check that this view
         *                    is non-null and of an appropriate type before using. If it is not possible to convert
         *                    this view to display the correct data, this method can create a new view.
         *                    Heterogeneous lists can specify their number of view types, so that this View is
         *                    always of the right type (see {@link #getViewTypeCount()} and
         *                    {@link #getItemViewType(int)}).
         * @param parent      The parent that this view will eventually be attached to
         * @return A View corresponding to the data at the specified position.
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = getLayoutInflater().inflate(R.layout.snack_choices, null);
            return v;
        }
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