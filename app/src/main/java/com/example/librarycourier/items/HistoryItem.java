package com.example.librarycourier.items;

import android.os.Parcel;
import android.os.Parcelable;

public class HistoryItem implements Parcelable {

    private String itemID;
    private String itemPrice;
    private String itemUserName;

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemUserName() {
        return itemUserName;
    }

    public void setItemUserName(String itemUserName) {
        this.itemUserName = itemUserName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.itemID);
        dest.writeString(this.itemPrice);
        dest.writeString(this.itemUserName);
    }

    public void readFromParcel(Parcel source) {
        this.itemID = source.readString();
        this.itemPrice = source.readString();
        this.itemUserName = source.readString();
    }

    public HistoryItem() {
    }

    protected HistoryItem(Parcel in) {
        this.itemID = in.readString();
        this.itemPrice = in.readString();
        this.itemUserName = in.readString();
    }

    public static final Parcelable.Creator<HistoryItem> CREATOR = new Parcelable.Creator<HistoryItem>() {
        @Override
        public HistoryItem createFromParcel(Parcel source) {
            return new HistoryItem(source);
        }

        @Override
        public HistoryItem[] newArray(int size) {
            return new HistoryItem[size];
        }
    };
}
