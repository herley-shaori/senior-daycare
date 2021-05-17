package com.properties;

import android.os.Parcel;
import android.os.Parcelable;

public interface Person extends Parcelable {
    boolean IS_MOBILE_TRANSPORT = false;

    static Person getInstance(){
        return new PersonImp();
    }

    void setFoodChoices(Food food);
    void setSnackChoices(Snack snack);
    void setMobileTransport(MobileTransport mobileTransport);
    void setDaycareDate(String date);
    void setLocation(Location location);

    Food getFood();
    Snack getSnack();
    MobileTransport getMobileTransport();
    Location getLocation();
    String getDaycareDate();
}

class PersonImp implements Person{
    private Food food;
    private Snack snack;
    private MobileTransport mobileTransport;
    private String daycareDate;
    private Location location;

    public PersonImp(Parcel source){
        this.food = source.readParcelable(getClass().getClassLoader());
        this.location = source.readParcelable(getClass().getClassLoader());
        this.daycareDate = source.readString();
    }

    public PersonImp() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.food, flags);
        dest.writeParcelable(this.location, flags);
        dest.writeString(this.daycareDate);
    }

    // Cukup sesuaikan nama objeknya
    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new PersonImp(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public void setFoodChoices(Food food) {
        this.food = food;
    }

    @Override
    public void setSnackChoices(Snack snack) {
        this.snack = snack;
    }

    @Override
    public void setMobileTransport(MobileTransport mobileTransport) {
        this.mobileTransport = mobileTransport;
    }

    @Override
    public void setDaycareDate(String date) {
        this.daycareDate = date;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public Food getFood() {
        return this.food;
    }

    @Override
    public Snack getSnack() {
        return this.snack;
    }

    @Override
    public MobileTransport getMobileTransport() {
        return this.mobileTransport;
    }

    @Override
    public Location getLocation() {
        return this.location;
    }

    @Override
    public String getDaycareDate() {
        return this.daycareDate;
    }
}