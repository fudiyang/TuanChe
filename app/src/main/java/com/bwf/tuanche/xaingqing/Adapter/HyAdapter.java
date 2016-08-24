package com.bwf.tuanche.xaingqing.Adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.xaingqing.entiy.hunying.HyRusert;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by admin on 2016/8/19.
 */
public class HyAdapter extends BaseListAdpter<HyRusert,HyAdapter.MViewHodler> {

    public HyAdapter(Context context) {
        super(context);
    }

    @Override
    public int getResourceId() {
        return R.layout.item_hunying;
    }

    @Override
    public MViewHodler onCreateViewHolder(ViewGroup parent) {
        MViewHodler mViewHodler =new MViewHodler();
        mViewHodler.tv_100=findViewByIdNoCast(R.id.tv_100);
        mViewHodler.tv_101=findViewByIdNoCast(R.id.tv_101);
        mViewHodler.tv_102=findViewByIdNoCast(R.id.tv_102);
        mViewHodler.img_tupian=findViewByIdNoCast(R.id.img_tupian);
        return mViewHodler;
    }

    @Override
    public void onBindViewHolder(MViewHodler holder, HyRusert rusert, int position) {
        LogUtils.i( rusert.toString());
          holder.tv_100.setText(rusert.styleName);
          holder.tv_101.setText("指导价："+rusert.factoryPrice);
          holder.tv_102.setText(rusert.content);

          ImageLoader.getInstance().disPlayImage(holder.img_tupian,rusert.logo);
    }

    public class MViewHodler extends BaseListAdpter.ViewHolder {
        private TextView tv_100, tv_101, tv_102;
        private SimpleDraweeView img_tupian;
    }

}
