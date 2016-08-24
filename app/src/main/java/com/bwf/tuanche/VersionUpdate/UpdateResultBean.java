package com.bwf.tuanche.VersionUpdate;

import android.os.Parcel;
import android.os.Parcelable;

import com.bwf.framwork.base.BaseBean;

/**
 * Created by admin on 2016/8/19.
 */
public class UpdateResultBean extends BaseBean implements Parcelable {

    public int versionCode;

    public String versionName;

    public String url;

    public String md5file;

    public String description;

    public String upgradeStringervalWarn;

    public boolean isFourceUpGrade;

    public boolean isPromtUpGrade;

    public String titleText;

    public String giveUpText;

    public String upgradeText;

    public String textPic;

    public String isForce;

    public String specificEdition;

    public String minVersion;



    @Override
    public String toString() {
        return "UpdateResultBean{" +
                "versionCode=" + versionCode +
                ", versionName='" + versionName + '\'' +
                ", url='" + url + '\'' +
                ", md5file='" + md5file + '\'' +
                ", description='" + description + '\'' +
                ", upgradeStringervalWarn='" + upgradeStringervalWarn + '\'' +
                ", isFourceUpGrade=" + isFourceUpGrade +
                ", isPromtUpGrade=" + isPromtUpGrade +
                ", titleText='" + titleText + '\'' +
                ", giveUpText='" + giveUpText + '\'' +
                ", upgradeText='" + upgradeText + '\'' +
                ", textPic='" + textPic + '\'' +
                ", isForce='" + isForce + '\'' +
                ", specificEdition='" + specificEdition + '\'' +
                ", minVersion='" + minVersion + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.versionCode);
        dest.writeString(this.versionName);
        dest.writeString(this.url);
        dest.writeString(this.md5file);
        dest.writeString(this.description);
        dest.writeString(this.upgradeStringervalWarn);
        dest.writeByte(this.isFourceUpGrade ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isPromtUpGrade ? (byte) 1 : (byte) 0);
        dest.writeString(this.titleText);
        dest.writeString(this.giveUpText);
        dest.writeString(this.upgradeText);
        dest.writeString(this.textPic);
        dest.writeString(this.isForce);
        dest.writeString(this.specificEdition);
        dest.writeString(this.minVersion);
    }

    public UpdateResultBean() {
    }

    protected UpdateResultBean(Parcel in) {
        this.versionCode = in.readInt();
        this.versionName = in.readString();
        this.url = in.readString();
        this.md5file = in.readString();
        this.description = in.readString();
        this.upgradeStringervalWarn = in.readString();
        this.isFourceUpGrade = in.readByte() != 0;
        this.isPromtUpGrade = in.readByte() != 0;
        this.titleText = in.readString();
        this.giveUpText = in.readString();
        this.upgradeText = in.readString();
        this.textPic = in.readString();
        this.isForce = in.readString();
        this.specificEdition = in.readString();
        this.minVersion = in.readString();
    }

    public static final Creator<UpdateResultBean> CREATOR = new Creator<UpdateResultBean>() {
        @Override
        public UpdateResultBean createFromParcel(Parcel source) {
            return new UpdateResultBean(source);
        }

        @Override
        public UpdateResultBean[] newArray(int size) {
            return new UpdateResultBean[size];
        }
    };
}
