package com.properties;

import android.os.Parcel;
import android.os.Parcelable;

public class MobileTransport implements Parcelable {

    public MobileTransport(){

    }

    public MobileTransport(Parcel in){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Parcelable.Creator<MobileTransport> CREATOR = new Parcelable.Creator<MobileTransport>() {
        @Override
        public MobileTransport createFromParcel(Parcel source) {
            return new MobileTransport(source);
        }

        @Override
        public MobileTransport[] newArray(int size) {
            return new MobileTransport[size];
        }
    };
}
