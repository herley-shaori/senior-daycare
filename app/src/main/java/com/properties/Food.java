package com.properties;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {

    private int hargaTotalFood;

    public Food() {

    }

    public Food(Parcel in) {
        this.hargaTotalFood = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.hargaTotalFood);
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

    public int getHargaTotalFood() {
        return hargaTotalFood;
    }

    public void setHargaTotalFood(int hargaTotalFood) {
        this.hargaTotalFood = hargaTotalFood;
    }
}
