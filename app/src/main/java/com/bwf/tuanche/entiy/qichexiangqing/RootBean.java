package com.bwf.tuanche.entiy.qichexiangqing;

import com.bwf.framwork.base.BaseBean;

/**
 * Created by admin on 2016/8/17.
 */
public class RootBean extends BaseBean{
    public String id;

    public String dataType;

    public String datakey;

    public String dataValue;

    public String title;

    public String describe;

    public String linkurl;

    public String imgurl;

    public String versionCode;

    public String sourceId;

    public String sort;

    public String status;

    public String isDel;

    public String createTime;

    public String ts;

    @Override
    public String toString() {
        return "RootBean{" +
                "id='" + id + '\'' +
                ", dataType='" + dataType + '\'' +
                ", datakey='" + datakey + '\'' +
                ", dataValue='" + dataValue + '\'' +
                ", title='" + title + '\'' +
                ", describe='" + describe + '\'' +
                ", linkurl='" + linkurl + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", versionCode='" + versionCode + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", sort='" + sort + '\'' +
                ", status='" + status + '\'' +
                ", isDel='" + isDel + '\'' +
                ", createTime='" + createTime + '\'' +
                ", ts='" + ts + '\'' +
                '}';
    }
}
