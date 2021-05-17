package com.properties;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {

    private String location;
    public Location(String location) {
        this.location = location;
    }

    public Location(Parcel in) {
        this.location = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.location);
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
}
