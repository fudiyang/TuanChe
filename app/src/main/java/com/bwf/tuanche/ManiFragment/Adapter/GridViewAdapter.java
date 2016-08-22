package com.bwf.tuanche.ManiFragment.Adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.ManiFragment.ShouEntity.OneEntity;
import com.bwf.tuanche.R;
import com.facebook.drawee.view.SimpleDraweeView;


/**
 * Created by Cheng on 2016/8/17.
 * Description:
 */
public class GridViewAdapter extends BaseListAdpter<OneEntity,GridViewAdapter.MyViewHolder>{

    public GridViewAdapter(Context context) {
        super(context);
    }

    @Override
    public int getResourceId() {
        return R.layout.item_one;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent) {
        MyViewHolder viewHolder = new MyViewHolder();
        viewHolder.img_dijia= findViewByIdNoCast(R.id.img_dijia);
        viewHolder.tv_dijia= findViewByIdNoCast(R.id.tv_dijia);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, OneEntity oneEntity, int position) {
        ImageLoader.getInstance().disPlayImage(holder.img_dijia,oneEntity.pic);
        holder.tv_dijia.setText(oneEntity.name);

    }


    public class MyViewHolder extends  BaseListAdpter.ViewHolder{
            public SimpleDraweeView img_dijia;
            public TextView tv_dijia;
    }

}
