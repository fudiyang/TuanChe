package com.bwf.tuanche.ManiFragment.ShouEntity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Cheng on 2016/8/18.
 * Description:
 */
public class MapEntity implements Parcelable {
    public String id;

    public String name;

    public String pinyin;

    public String py;

    public String openStatus;

    @Override
    public String toString() {
        return "MapEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", py='" + py + '\'' +
                ", openStatus='" + openStatus + '\'' +
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
        dest.writeString(this.pinyin);
        dest.writeString(this.py);
        dest.writeString(this.openStatus);
    }

    public MapEntity() {
    }

    protected MapEntity(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.pinyin = in.readString();
        this.py = in.readString();
        this.openStatus = in.readString();
    }

    public static final Parcelable.Creator<MapEntity> CREATOR = new Parcelable.Creator<MapEntity>() {
        @Override
        public MapEntity createFromParcel(Parcel source) {
            return new MapEntity(source);
        }

        @Override
        public MapEntity[] newArray(int size) {
            return new MapEntity[size];
        }
    };
}
