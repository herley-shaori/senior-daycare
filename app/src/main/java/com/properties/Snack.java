package com.properties;

import android.os.Parcel;
import android.os.Parcelable;

public class Snack implements Parcelable {

    public Snack(){

    }

    public Snack(Parcel in){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

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
}
