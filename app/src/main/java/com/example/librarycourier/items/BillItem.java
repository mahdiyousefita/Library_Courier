package com.example.librarycourier.items;

import android.os.Parcel;
import android.os.Parcelable;

public class BillItem implements Parcelable {

    private String recordDate;
    private String price;
    private String status;

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.recordDate);
        dest.writeString(this.price);
        dest.writeString(this.status);
    }

    public void readFromParcel(Parcel source) {
        this.recordDate = source.readString();
        this.price = source.readString();
        this.status = source.readString();
    }

    public BillItem() {
    }

    protected BillItem(Parcel in) {
        this.recordDate = in.readString();
        this.price = in.readString();
        this.status = in.readString();
    }

    public static final Parcelable.Creator<BillItem> CREATOR = new Parcelable.Creator<BillItem>() {
        @Override
        public BillItem createFromParcel(Parcel source) {
            return new BillItem(source);
        }

        @Override
        public BillItem[] newArray(int size) {
            return new BillItem[size];
        }
    };
}
