package com.bwf.tuanche.xaingqing.entiy.remen;

import java.util.List;

/**
 * Created by admin on 2016/8/23.
 */
public class BrandIDBean {
    public String brandId;

    public String brandName;

    public String brandPic;

    public List<BrandIDResultBean> styleList;

    @Override
    public String toString() {
        return "BrandIDBean{" +
                "brandId='" + brandId + '\'' +
                ", brandName='" + brandName + '\'' +
                ", brandPic='" + brandPic + '\'' +
                ", styleList=" + styleList +
                '}';
    }
}
