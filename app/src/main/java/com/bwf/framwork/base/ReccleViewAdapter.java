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
        return R.layout.item_test;
    }

    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent) {
        MyViewHodler viewHodler = new MyViewHodler();
        viewHodler.tv_test = findViewByIdNoCast(R.id.tv_test);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(MyViewHodler holder, String userBean, int position) {

        holder.tv_test.setText(userBean);

    }

    public class MyViewHodler extends BaseListAdpter.ViewHolder {

        public TextView tv_test;

    }

}
