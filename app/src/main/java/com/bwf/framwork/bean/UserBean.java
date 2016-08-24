package com.bwf.framwork.bean;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by Lizhangfeng on 2016/8/8 0008.
 * Description: 用户bean
 */
public class UserBean implements Parcelable{

    public String info;
    public String dateTime;

    public UserBean() {
    }

    public UserBean(String info, String dateTime) {
        this.info = info;
        this.dateTime = dateTime;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.info);
        dest.writeString(this.dateTime);
    }

    protected UserBean(Parcel in) {
        this.info = in.readString();
        this.dateTime = in.readString();
    }

    public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
        @Override
        public UserBean createFromParcel(Parcel source) {
            return new UserBean(source);
        }

        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }
    };



}
