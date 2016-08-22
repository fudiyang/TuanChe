package com.bwf.tuanche.ManiFragment.ShouEntity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Cheng on 2016/8/17.
 * Description:
 */
public class ThreeEntity1 implements Parcelable {
    public String id;

    public String adName;

    public String channelType;

    public String beginVersion;

    public String position;

    public String priority;

    public String adImgUrl;

    public String description;

    public String shareTitle;

    public String shareImgUrl;

    public String shareUrl;

    public String city;

    public String begStringime;

    public String endTime;

    public String adType;

    public String pageType;

    public String adParam;

    public String adInfoUrl;

    public String adStatus;

    public String isDelete;

    public String createTime;

    public String createUserId;

    public String updateTime;

    public String updateUserId;

    public String picShowType;

    @Override
    public String toString() {
        return "ThreeEntity1{" +
                "id=" + id +
                ", adName='" + adName + '\'' +
                ", channelType=" + channelType +
                ", beginVersion='" + beginVersion + '\'' +
                ", position=" + position +
                ", priority=" + priority +
                ", adImgUrl='" + adImgUrl + '\'' +
                ", description='" + description + '\'' +
                ", shareTitle='" + shareTitle + '\'' +
                ", shareImgUrl='" + shareImgUrl + '\'' +
                ", shareUrl='" + shareUrl + '\'' +
                ", city='" + city + '\'' +
                ", begStringime=" + begStringime +
                ", endTime=" + endTime +
                ", adType=" + adType +
                ", pageType=" + pageType +
                ", adParam='" + adParam + '\'' +
                ", adInfoUrl='" + adInfoUrl + '\'' +
                ", adStatus=" + adStatus +
                ", isDelete=" + isDelete +
                ", createTime=" + createTime +
                ", createUserId=" + createUserId +
                ", updateTime=" + updateTime +
                ", updateUserId=" + updateUserId +
                ", picShowType=" + picShowType +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.adName);
        dest.writeString(this.channelType);
        dest.writeString(this.beginVersion);
        dest.writeString(this.position);
        dest.writeString(this.priority);
        dest.writeString(this.adImgUrl);
        dest.writeString(this.description);
        dest.writeString(this.shareTitle);
        dest.writeString(this.shareImgUrl);
        dest.writeString(this.shareUrl);
        dest.writeString(this.city);
        dest.writeString(this.begStringime);
        dest.writeString(this.endTime);
        dest.writeString(this.adType);
        dest.writeString(this.pageType);
        dest.writeString(this.adParam);
        dest.writeString(this.adInfoUrl);
        dest.writeString(this.adStatus);
        dest.writeString(this.isDelete);
        dest.writeString(this.createTime);
        dest.writeString(this.createUserId);
        dest.writeString(this.updateTime);
        dest.writeString(this.updateUserId);
        dest.writeString(this.picShowType);
    }

    public ThreeEntity1() {
    }

    protected ThreeEntity1(Parcel in) {
        this.id = in.readString();
        this.adName = in.readString();
        this.channelType = in.readString();
        this.beginVersion = in.readString();
        this.position = in.readString();
        this.priority = in.readString();
        this.adImgUrl = in.readString();
        this.description = in.readString();
        this.shareTitle = in.readString();
        this.shareImgUrl = in.readString();
        this.shareUrl = in.readString();
        this.city = in.readString();
        this.begStringime = in.readString();
        this.endTime = in.readString();
        this.adType = in.readString();
        this.pageType = in.readString();
        this.adParam = in.readString();
        this.adInfoUrl = in.readString();
        this.adStatus = in.readString();
        this.isDelete = in.readString();
        this.createTime = in.readString();
        this.createUserId = in.readString();
        this.updateTime = in.readString();
        this.updateUserId = in.readString();
        this.picShowType = in.readString();
    }

    public static final Parcelable.Creator<ThreeEntity1> CREATOR = new Parcelable.Creator<ThreeEntity1>() {
        @Override
        public ThreeEntity1 createFromParcel(Parcel source) {
            return new ThreeEntity1(source);
        }

        @Override
        public ThreeEntity1[] newArray(int size) {
            return new ThreeEntity1[size];
        }
    };
}
