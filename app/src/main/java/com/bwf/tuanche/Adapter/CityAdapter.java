package com.bwf.tuanche.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.entiy.frist.CityResultBean;
import com.bwf.tuanche.entiy.frist.ListCityEntity;

import java.util.List;

/**
 * Created by admin on 2016/8/24.
 */
public class CityAdapter extends BaseListAdpter<ListCityEntity,CityAdapter.MyjyViewHodler> {

    public CityAdapter(Context context) {
        super(context);
    }

    @Override
    public int getResourceId() {
        return R.layout.item_city;
    }

    @Override
    public MyjyViewHodler onCreateViewHolder(ViewGroup parent) {
        MyjyViewHodler viewHodler=new MyjyViewHodler();
        viewHodler.tv_1=findViewByIdNoCast(R.id.tv_1);
        viewHodler.tv_2=findViewByIdNoCast(R.id.tv_2);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(MyjyViewHodler holder, ListCityEntity listCityEntity, int position) {
        holder.tv_2.setText(listCityEntity.name);
        //截取拼音转换层大写后的第一个字母
        String str=listCityEntity.pinyin.toUpperCase().trim().substring(0,1);
        holder.tv_1.setText(str);
        holder.tv_1.setVisibility(View.VISIBLE);
        if(position>1){
            ListCityEntity listCityEntity1= (ListCityEntity) getItem(position-1);
            String str1=listCityEntity1.pinyin.toUpperCase().trim().substring(0,1);
            if(str1.equals(str)){
                holder.tv_1.setVisibility(View.GONE);
            }else {
                holder.tv_1.setVisibility(View.VISIBLE);
            }
        }
    }

    public class MyjyViewHodler extends BaseListAdpter.ViewHolder{
        private TextView tv_1;
        private TextView tv_2;
    }


}
