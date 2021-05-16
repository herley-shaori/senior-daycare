package com.properties;

import android.os.Parcel;
import android.os.Parcelable;

public interface Person extends Parcelable {
    boolean IS_MOBILE_TRANSPORT = false;

    static Person getInstance(){
        return new PersonImp();
    }

    void setFoodChoices();
    void setSnackChoices();
    void setMobileTransport();

    Food getFood();
}

class PersonImp implements Person{

    private Food food;

    public PersonImp(Parcel source){
        this.food = source.readTypedObject(source.readParcelable(getClass().getClassLoader()));
    }

    public PersonImp() {
    }

    @Override
    public void setFoodChoices() {

    }

    @Override
    public void setSnackChoices() {

    }

    @Override
    public void setMobileTransport() {

    }

    @Override
    public Food getFood() {
        return this.food;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.food, flags);
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
}
