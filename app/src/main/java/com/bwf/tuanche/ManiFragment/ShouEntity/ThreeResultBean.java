package com.bwf.tuanche.ManiFragment.ShouEntity;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by Cheng on 2016/8/17.
 * Description:
 */
public class ThreeResultBean{

    public List<ThreeEntity> header_banner;
    public List<ThreeEntity1> center_banner;
    public List<ThreeEntity2> position_banner;

    @Override
    public String toString() {
        return "ThreeResultBean{" +
                "header_banner=" + header_banner +
                ", center_banne=" + center_banner +
                ", position_banner=" + position_banner +
                '}';
    }
}
