package com.bwf.framwork.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.bwf.framwork.base.BaseBean;

/**
 * Created by Lizhangfeng on 2016/8/8 0008.
 * Description: 用户bean
 */
public class UserBean extends BaseBean implements Parcelable {

    public String userId;
    public String userName;

    public UserBean() {
    }

    public UserBean(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userId);
        dest.writeString(this.userName);
    }

    protected UserBean(Parcel in) {
        this.userId = in.readString();
        this.userName = in.readString();
    }

    public static final Parcelable.Creator<UserBean> CREATOR = new Parcelable.Creator<UserBean>() {
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
