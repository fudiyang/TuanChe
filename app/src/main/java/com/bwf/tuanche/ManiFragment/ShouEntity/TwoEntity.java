package com.bwf.tuanche.ManiFragment.ShouEntity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Cheng on 2016/8/17.
 * Description:
 */
public class TwoEntity implements Parcelable {
    public String id;

    public String name;

    public String logo;

    public String baseNum;

    public String modelType;

    public TwoEntity(String name, String logo) {
        this.name = name;
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "TwoEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", baseNum=" + baseNum +
                ", modelType=" + modelType +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.logo);
        dest.writeString(this.baseNum);
        dest.writeString(this.modelType);
    }

    public TwoEntity() {
    }

    protected TwoEntity(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.logo = in.readString();
        this.baseNum = in.readString();
        this.modelType = in.readString();
    }

    public static final Creator<TwoEntity> CREATOR = new Creator<TwoEntity>() {
        @Override
        public TwoEntity createFromParcel(Parcel source) {
            return new TwoEntity(source);
        }

        @Override
        public TwoEntity[] newArray(int size) {
            return new TwoEntity[size];
        }
    };
}
