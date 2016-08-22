package com.bwf.tuanche.ManiFragment.ShouEntity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Cheng on 2016/8/17.
 * Description:
 */
public class ThreeEntity2 implements Parcelable {
    public String subTitle;

    public String bigTitle;

    public String adpInfoUrl;

    public String positionId;

    public String iconUrl;

    public String positionType;

    public String adType;

    @Override
    public String toString() {
        return "ThreeEntity2{" +
                "subTitle='" + subTitle + '\'' +
                ", bigTitle='" + bigTitle + '\'' +
                ", adpInfoUrl='" + adpInfoUrl + '\'' +
                ", positionId=" + positionId +
                ", iconUrl='" + iconUrl + '\'' +
                ", positionType=" + positionType +
                ", adType='" + adType + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.subTitle);
        dest.writeString(this.bigTitle);
        dest.writeString(this.adpInfoUrl);
        dest.writeString(this.positionId);
        dest.writeString(this.iconUrl);
        dest.writeString(this.positionType);
        dest.writeString(this.adType);
    }

    public ThreeEntity2() {
    }

    protected ThreeEntity2(Parcel in) {
        this.subTitle = in.readString();
        this.bigTitle = in.readString();
        this.adpInfoUrl = in.readString();
        this.positionId = in.readString();
        this.iconUrl = in.readString();
        this.positionType = in.readString();
        this.adType = in.readString();
    }

    public static final Parcelable.Creator<ThreeEntity2> CREATOR = new Parcelable.Creator<ThreeEntity2>() {
        @Override
        public ThreeEntity2 createFromParcel(Parcel source) {
            return new ThreeEntity2(source);
        }

        @Override
        public ThreeEntity2[] newArray(int size) {
            return new ThreeEntity2[size];
        }
    };
}
