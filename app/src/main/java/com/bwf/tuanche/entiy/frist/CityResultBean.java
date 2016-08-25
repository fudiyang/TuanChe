package com.bwf.tuanche.entiy.frist;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by Cheng on 2016/8/18.
 * Description:
 */
public class CityResultBean extends BaseBean {

    public List<HotCityEntity> hotCitys;
    public List<ListCityEntity> openCitys;

    @Override
    public String toString() {
        return "CityResultBean{" +
                "hotCitys=" + hotCitys +
                ", openCitys=" + openCitys +
                '}';
    }
}
