package com.properties;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {

    private String location;
    private int choiceOfStay;
    private int hargaService;
    private int lengthOfStay;
    private int totalHargaLocation;

    public Location(String location, int choiceOfStay, int hargaService, int lengthOfStay, int totalHargaLocation) {
        this.location = location;
        this.choiceOfStay = choiceOfStay;
        this.hargaService = hargaService;
        this.lengthOfStay = lengthOfStay;
        this.totalHargaLocation = totalHargaLocation;
    }

    public Location(Parcel in) {
        this.location = in.readString();
        this.choiceOfStay = in.readInt();
        this.hargaService = in.readInt();
        this.totalHargaLocation = in.readInt();
        this.lengthOfStay = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.location);
        dest.writeInt(this.choiceOfStay);
        dest.writeInt(this.hargaService);
        dest.writeInt(this.totalHargaLocation);
        dest.writeInt(this.lengthOfStay);
    }

    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {

        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public String getLocation(){
        return this.location;
    }

    public int getChoiceOfStay() {
        return choiceOfStay;
    }

    public void setChoiceOfStay(int choiceOfStay) {
        this.choiceOfStay = choiceOfStay;
        if(this.location.equals("Citra Premier Luxury Seniors Clubhouse")){
            this.hargaService = this.choiceOfStay * 350000;
        }else if(this.location.equals("Panti Jompo Waluya Sejati Abadi")){
            this.hargaService = this.choiceOfStay * 250000;
        }
    }

    /**
     * Harga tempat tinggal.
     * @return
     */
    public int getHargaService(){
        return this.hargaService;
    }

    public int getLengthOfStay() {
        return lengthOfStay;
    }

    public void setLengthOfStay(int lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
    }

    public int getTotalHargaLocation() {
        return totalHargaLocation;
    }

    public void setTotalHargaLocation(int totalHargaLocation) {
        this.totalHargaLocation = totalHargaLocation;
    }
}