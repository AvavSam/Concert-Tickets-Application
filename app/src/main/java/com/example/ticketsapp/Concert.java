package com.example.ticketsapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Concert implements Parcelable {
    private String name;
    private String location;
    private String date;
    private String price;
    private String count;
    private String status;
    private int imageResource;

    public Concert(String name, String location, String date, String price, String status, String count, int imageResource) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.price = price;
        this.imageResource = imageResource;
        this.count = count;
        this.status = status;
    }

    public Concert() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(location);
        parcel.writeString(date);
        parcel.writeString(price);
        parcel.writeInt(imageResource);
    }

    public static final Parcelable.Creator<Concert> CREATOR = new Parcelable.Creator<Concert>() {
        public Concert createFromParcel(Parcel in) {
            return new Concert(in);
        }

        public Concert[] newArray(int size) {
            return new Concert[size];
        }
    };

    private Concert(Parcel in) {
        name = in.readString();
        location = in.readString();
        date = in.readString();
        price = in.readString();
        imageResource = in.readInt();
    }

    public String getCount() {
        return count;
    }
    public void setCount(String count) {
        this.count = count;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}