package com.bwf.tuanche.Search.entity.ed_search;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by admin on 2016/8/17.
 */
public class EdSecondResult implements Parcelable {
    public String brandId;
    public String brandName;
    public String brandPic;
    public List<EdThridBean> styleList ;

    @Override
    public String toString() {
        return "EdSecondResult{" +
                "brandId='" + brandId + '\'' +
                ", brandName='" + brandName + '\'' +
                ", brandPic='" + brandPic + '\'' +
                ", styleList=" + styleList +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.brandId);
        dest.writeString(this.brandName);
        dest.writeString(this.brandPic);
        dest.writeTypedList(this.styleList);
    }

    public EdSecondResult() {
    }

    protected EdSecondResult(Parcel in) {
        this.brandId = in.readString();
        this.brandName = in.readString();
        this.brandPic = in.readString();
        this.styleList = in.createTypedArrayList(EdThridBean.CREATOR);
    }

    public static final Parcelable.Creator<EdSecondResult> CREATOR = new Parcelable.Creator<EdSecondResult>() {
        @Override
        public EdSecondResult createFromParcel(Parcel source) {
            return new EdSecondResult(source);
        }

        @Override
        public EdSecondResult[] newArray(int size) {
            return new EdSecondResult[size];
        }
    };
}
