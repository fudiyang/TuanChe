package com.bwf.tuanche.xaingqing.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.xaingqing.entiy.remen.BrandIDBean;
import com.bwf.tuanche.xaingqing.entiy.remen.BrandIDResultBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by admin on 2016/8/23.
 */
public class ListViewAdapter extends BaseListAdpter<BrandIDResultBean,ListViewAdapter.MyjyViewHodler> {
   public ListViewAdapter(Context context){
         super(context);
   }
    @Override
    public int getResourceId() {
        return R.layout.item_remen;
    }
    @Override
    public MyjyViewHodler onCreateViewHolder(ViewGroup parent) {;
         MyjyViewHodler viewHodler=new MyjyViewHodler();
         viewHodler.img_remen=findViewByIdNoCast(R.id.img_remencar);
         viewHodler.tv_renmen1=findViewByIdNoCast(R.id.tv_remen_carname);
         viewHodler.tv_renmen2=findViewByIdNoCast(R.id.tv_remen_carprice);
        return viewHodler;

    }

    @Override
    public void onBindViewHolder(MyjyViewHodler holder, BrandIDResultBean result, int position) {
        holder.tv_renmen1.setText(result.styleName);
        holder.tv_renmen2.setText("指导价："+result.factoryPrice);
        ImageLoader.getInstance().disPlayImage(holder.img_remen,result.logo);
    }


    public class MyjyViewHodler extends BaseListAdpter.ViewHolder{
        public SimpleDraweeView img_remen;
        public TextView tv_renmen1;
        public TextView tv_renmen2;
    }
}
