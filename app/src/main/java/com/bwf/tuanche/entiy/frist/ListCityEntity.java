package com.bwf.tuanche.entiy.frist;

import android.os.Parcel;
import android.os.Parcelable;

import com.bwf.framwork.base.BaseBean;

/**
 * Created by Cheng on 2016/8/18.
 * Description:
 */
public class ListCityEntity implements Parcelable {
            public String id;// 197             
            public String name;// 鞍山            
            public String province;// 辽宁          
            public String pinyin;// anshan            
            public String citycode;// null               
            public String pname;// 东北区   
            public String py;// aspublic String             
            public String openStatus ;// 0          
            public String manNum;// null

    @Override
    public String toString() {
        return "ListCityEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", citycode='" + citycode + '\'' +
                ", pname='" + pname + '\'' +
                ", py='" + py + '\'' +
                ", openStatus='" + openStatus + '\'' +
                ", manNum='" + manNum + '\'' +
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
        dest.writeString(this.province);
        dest.writeString(this.pinyin);
        dest.writeString(this.citycode);
        dest.writeString(this.pname);
        dest.writeString(this.py);
        dest.writeString(this.openStatus);
        dest.writeString(this.manNum);
    }

    public ListCityEntity() {
    }

    protected ListCityEntity(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.province = in.readString();
        this.pinyin = in.readString();
        this.citycode = in.readString();
        this.pname = in.readString();
        this.py = in.readString();
        this.openStatus = in.readString();
        this.manNum = in.readString();
    }

    public static final Creator<ListCityEntity> CREATOR = new Creator<ListCityEntity>() {
        @Override
        public ListCityEntity createFromParcel(Parcel source) {
            return new ListCityEntity(source);
        }

        @Override
        public ListCityEntity[] newArray(int size) {
            return new ListCityEntity[size];
        }
    };
}
