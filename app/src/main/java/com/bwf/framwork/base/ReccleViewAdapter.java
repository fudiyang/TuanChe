package com.bwf.framwork.base;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.tuanche.R;

/**
 * Created by Lizhangfeng on 2016/8/16 0016.
 * Description:
 */
public class ReccleViewAdapter extends BaseListAdpter<String, ReccleViewAdapter.MyViewHodler> {

    public ReccleViewAdapter(Context context) {
        super(context);
    }

    @Override
    public int getResourceId() {
        return R.layout.activity_details;
    }

    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent) {
        MyViewHodler viewHodler = new MyViewHodler();

        return viewHodler;
    }

    @Override
    public void onBindViewHolder(MyViewHodler holder, String userBean, int position) {

    }

    public class MyViewHodler extends BaseListAdpter.ViewHolder {

    }

}
