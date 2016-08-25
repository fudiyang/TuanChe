package com.bwf.tuanche.ManiFragment.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bwf.tuanche.ManiFragment.ShouEntity.HotCityEntity;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;

import java.util.List;

/**
 * Created by Cheng on 2016/8/18.
 * Description:
 */
public class MapAdapterOne extends RecyclerView.Adapter<MapAdapterOne.CityViewHodler>{
    private Context context;
    private MapCallBack mapCallBack;
    private  String currentCityName;
    public void setMapCallBack(MapCallBack mapCallBack) {
        this.mapCallBack = mapCallBack;
    }

    private List<HotCityEntity> hotCityEntities;

    public void setHotCityEntities(List<HotCityEntity> hotCityEntities) {
        this.hotCityEntities = hotCityEntities;
    }

    public MapAdapterOne(Context context, String currentCityName) {
        this.context = context;
        this.currentCityName =currentCityName ;
    }

    @Override
    public CityViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =View.inflate(context, R.layout.item_map_one,null);
        CityViewHodler cityViewHodler = new CityViewHodler(view);
        cityViewHodler.tv_hotCity= (TextView) view.findViewById(R.id.tv_hotCity);
        return cityViewHodler;
    }

    @Override
    public void onBindViewHolder(final CityViewHodler holder, final int position) {
            if(currentCityName!=null){
                if (currentCityName.equals(hotCityEntities.get(position).name))
                    holder.tv_hotCity.setTextColor(Color.RED);
                else holder.tv_hotCity.setTextColor(Color.BLACK);
            }
            holder.tv_hotCity.setText(hotCityEntities.get(position).name);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mapCallBack!=null){
                        mapCallBack.OnItemClick(position);

                    }
                }
            });
    }

    @Override
    public int getItemCount() {
        return hotCityEntities==null?0:hotCityEntities.size();
    }

    public class CityViewHodler extends RecyclerView.ViewHolder{
        private TextView tv_hotCity;

        public CityViewHodler(View itemView) {
            super(itemView);
        }
    }
    public  interface  MapCallBack{
        void OnItemClick(int position);
    }
}
