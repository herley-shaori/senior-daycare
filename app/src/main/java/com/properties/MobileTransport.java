package com.properties;

import android.os.Parcel;
import android.os.Parcelable;

public class MobileTransport implements Parcelable {

    private int totalHargaMobileTransport;

    public MobileTransport(){

    }

    public MobileTransport(Parcel in){
        this.setTotalHargaMobileTransport(in.readInt());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.getTotalHargaMobileTransport());
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

    public int getTotalHargaMobileTransport() {
        return totalHargaMobileTransport;
    }

    public void setTotalHargaMobileTransport(int totalHargaMobileTransport) {
        this.totalHargaMobileTransport = totalHargaMobileTransport;
    }
}
