package com.example.lab234.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Fruit implements Parcelable {
    private String name;
    private int imageResource;
    private String description;

    public Fruit(String name, int imageResource, String description) {
        this.name = name;
        this.imageResource = imageResource;
        this.description = description;
    }

    protected Fruit(Parcel in) {
        name = in.readString();
        imageResource = in.readInt();
        description = in.readString();
    }

    public static final Creator<Fruit> CREATOR = new Creator<Fruit>() {
        @Override
        public Fruit createFromParcel(Parcel in) {
            return new Fruit(in);
        }

        @Override
        public Fruit[] newArray(int size) {
            return new Fruit[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(imageResource);
        dest.writeString(description);
    }
}
