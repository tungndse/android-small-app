package com.example.lab234.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Player implements Parcelable {

    private String name;
    private String monthDayOfBirth;
    private int yearOfBirth;
    private String currentAge;
    private int imageResource;
    private int flagImageResource;

    public Player(String name, String monthDayOfBirth,
                  int yearOfBirth, String currentAge,
                  int imageResource) {
        this.name = name;
        this.monthDayOfBirth = monthDayOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.currentAge = currentAge;
        this.imageResource = imageResource;
    }

    protected Player(Parcel in) {
        name = in.readString();
        monthDayOfBirth = in.readString();
        yearOfBirth = in.readInt();
        currentAge = in.readString();
        flagImageResource = in.readInt();
        imageResource = in.readInt();
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(monthDayOfBirth);
        parcel.writeInt(yearOfBirth);
        parcel.writeString(currentAge);
        parcel.writeInt(imageResource);
        parcel.writeInt(flagImageResource);
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonthDayOfBirth() {
        return monthDayOfBirth;
    }

    public void setMonthDayOfBirth(String monthDayOfBirth) {
        this.monthDayOfBirth = monthDayOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(String currentAge) {
        this.currentAge = currentAge;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getFlagImageResource() {
        return flagImageResource;
    }

    public void setFlagImageResource(int flagImageResource) {
        this.flagImageResource = flagImageResource;
    }

    @Override
    public int describeContents() {
        return 0;
    }


}
