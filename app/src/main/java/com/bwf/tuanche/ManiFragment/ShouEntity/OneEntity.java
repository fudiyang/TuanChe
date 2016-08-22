package com.bwf.tuanche.ManiFragment.ShouEntity;

import android.os.Parcel;
import android.os.Parcelable;

import com.bwf.framwork.base.BaseBean;

/**
 * Created by Cheng on 2016/8/17.
 * Description:
 */
public class OneEntity implements Parcelable {
        public int weight;

        public String name;

        public String pic;

        public boolean show;

        public int type;

        public int modules;

        public int is_ng;

        public int is_login;
    @Override
    public String toString() {
        return "OneEntity{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", show=" + show +
                ", type=" + type +
                ", modules=" + modules +
                ", is_ng=" + is_ng +
                ", is_login=" + is_login +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.weight);
        dest.writeString(this.name);
        dest.writeString(this.pic);
        dest.writeByte(this.show ? (byte) 1 : (byte) 0);
        dest.writeInt(this.type);
        dest.writeInt(this.modules);
        dest.writeInt(this.is_ng);
        dest.writeInt(this.is_login);
    }

    public OneEntity() {
    }

    protected OneEntity(Parcel in) {
        this.weight = in.readInt();
        this.name = in.readString();
        this.pic = in.readString();
        this.show = in.readByte() != 0;
        this.type = in.readInt();
        this.modules = in.readInt();
        this.is_ng = in.readInt();
        this.is_login = in.readInt();
    }

    public static final Parcelable.Creator<OneEntity> CREATOR = new Parcelable.Creator<OneEntity>() {
        @Override
        public OneEntity createFromParcel(Parcel source) {
            return new OneEntity(source);
        }

        @Override
        public OneEntity[] newArray(int size) {
            return new OneEntity[size];
        }
    };
}
