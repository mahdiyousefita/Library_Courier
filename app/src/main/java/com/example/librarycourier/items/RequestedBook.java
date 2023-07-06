package com.example.librarycourier.items;

import android.os.Parcel;
import android.os.Parcelable;

public class RequestedBook implements Parcelable {

    private int id;
    private int price;
    private String goalLoc;
    private String startLoc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGoalLoc() {
        return goalLoc;
    }

    public void setGoalLoc(String goalLoc) {
        this.goalLoc = goalLoc;
    }

    public String getStartLoc() {
        return startLoc;
    }

    public void setStartLoc(String startLoc) {
        this.startLoc = startLoc;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.price);
        dest.writeString(this.goalLoc);
        dest.writeString(this.startLoc);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.price = source.readInt();
        this.goalLoc = source.readString();
        this.startLoc = source.readString();
    }

    public RequestedBook() {
    }

    protected RequestedBook(Parcel in) {
        this.id = in.readInt();
        this.price = in.readInt();
        this.goalLoc = in.readString();
        this.startLoc = in.readString();
    }

    public static final Parcelable.Creator<RequestedBook> CREATOR = new Parcelable.Creator<RequestedBook>() {
        @Override
        public RequestedBook createFromParcel(Parcel source) {
            return new RequestedBook(source);
        }

        @Override
        public RequestedBook[] newArray(int size) {
            return new RequestedBook[size];
        }
    };
}
