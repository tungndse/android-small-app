package com.example.lab234.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {
    private String name;
    private int imageResource;

    public Food(String name, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
    }

    protected Food(Parcel in) {
        name = in.readString();
        imageResource = in.readInt();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(imageResource);
    }
}
