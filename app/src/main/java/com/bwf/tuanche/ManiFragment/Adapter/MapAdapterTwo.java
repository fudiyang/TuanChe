package com.bwf.tuanche.ManiFragment.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bwf.tuanche.ManiFragment.ShouEntity.ListCityEntity;
import com.bwf.tuanche.R;

import java.util.List;

/**
 * Created by Cheng on 2016/8/18.
 * Description:
 */
public class MapAdapterTwo extends RecyclerView.Adapter<MapAdapterTwo.ListCityViewHodler>{

    private Context context;

    private List<ListCityEntity> listCityEntities;
    private  MapCallBackList mapCallBackList;
    private String currentCityName;
    public void setMapCallBackList(MapCallBackList mapCallBackList) {
        this.mapCallBackList = mapCallBackList;
    }

    public MapAdapterTwo(Context context, String currentCityName) {
        this.context = context;
        this.currentCityName = currentCityName;
    }

    public void setListCityEntities(List<ListCityEntity> listCityEntities) {
        this.listCityEntities = listCityEntities;
    }

    @Override
    public ListCityViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_map_two,null);
        ListCityViewHodler listCityViewHodler = new ListCityViewHodler(view);
        listCityViewHodler.tv_zimu= (TextView) view.findViewById(R.id.tv_zimu);
        listCityViewHodler.tv_chengshi= (TextView) view.findViewById(R.id.tv_chengshi);
        return listCityViewHodler;
    }

    @Override
    public void onBindViewHolder(final ListCityViewHodler holder, final int position) {
            String newpinyin=listCityEntities.get(position).pinyin.toUpperCase().trim().substring(0,1);
            String oldpinyin=null;
            if (position!=0)
                oldpinyin=listCityEntities.get(position-1).pinyin.toUpperCase().trim().substring(0,1);
            if (oldpinyin!=null&&newpinyin.equals(oldpinyin)){
                holder.tv_zimu.setVisibility(View.GONE);
            }else
            holder.tv_zimu.setText(newpinyin);
           String name = listCityEntities.get(position).name;
          if(currentCityName!=null){
              if (currentCityName.equals(name))holder.tv_chengshi.setTextColor(Color.RED);
              else  holder.tv_chengshi.setTextColor(Color.BLACK);
          }
            holder.tv_chengshi.setText(name);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (mapCallBackList!=null){
                            mapCallBackList.OnItemListClick(position);
                    }
                }
            });


    }

    @Override
    public int getItemCount() {
        return listCityEntities==null?0:listCityEntities.size();
    }

    public class ListCityViewHodler extends RecyclerView.ViewHolder{
        private TextView tv_zimu,tv_chengshi;

        public ListCityViewHodler(View itemView) {

            super(itemView);
        }
    }
    public interface  MapCallBackList{
        void OnItemListClick(int position);
    }
}
