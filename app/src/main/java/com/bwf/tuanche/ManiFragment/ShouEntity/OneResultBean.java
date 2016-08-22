package com.bwf.tuanche.ManiFragment.ShouEntity;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by Cheng on 2016/8/17.
 * Description:
 */
public class OneResultBean extends BaseBean {

    public List<OneEntity> nc;

    @Override
    public String toString() {
        return "OneResultBean{" +
                "nc=" + nc +
                '}';
    }
}
