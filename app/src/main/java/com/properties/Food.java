package com.properties;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {

    public Food() {

    }

    public Food(Parcel in) {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Parcelable.Creator<Food> CREATOR = new Parcelable.Creator<Food>() {

        @Override
        public Food createFromParcel(Parcel source) {
            return new Food(source);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };
}
