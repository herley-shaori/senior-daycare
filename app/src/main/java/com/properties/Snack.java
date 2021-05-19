package com.properties;

import android.os.Parcel;
import android.os.Parcelable;

public class Snack implements Parcelable {

    private int hargaTotalSnack;

    public Snack(){

    }

    public Snack(Parcel in){
        this.hargaTotalSnack = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.hargaTotalSnack);
    }

    public static final Parcelable.Creator<Snack> CREATOR = new Parcelable.Creator<Snack>() {

        @Override
        public Snack createFromParcel(Parcel source) {
            return new Snack(source);
        }

        @Override
        public Snack[] newArray(int size) {
            return new Snack[size];
        }
    };

    public int getHargaTotalSnack() {
        return hargaTotalSnack;
    }

    public void setHargaTotalSnack(int hargaTotalSnack) {
        this.hargaTotalSnack = hargaTotalSnack;
    }
}
