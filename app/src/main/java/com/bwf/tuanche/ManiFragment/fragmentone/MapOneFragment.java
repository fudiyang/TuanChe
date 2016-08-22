package com.bwf.tuanche.ManiFragment.fragmentone;



import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.DividerItemDecoration;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.ManiFragment.Adapter.MapAdapterOne;
import com.bwf.tuanche.ManiFragment.ShouEntity.HotCityEntity;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;

import java.util.List;

public class MapOneFragment extends BaseFragment implements MapAdapterOne.MapCallBack{
    private RecyclerView rl_hotCity;
    private MapAdapterOne mapAdapterOne;
    private List<HotCityEntity> hotCityEntities;
    private DividerItemDecoration dividerItemDecoration;
    private DividerItemDecoration dividerItemDecoration1;
    private String cityId;

    public void setHotCityEntities(List<HotCityEntity> hotCityEntities) {
        this.hotCityEntities = hotCityEntities;
       mapAdapterOne.setHotCityEntities(hotCityEntities);
        mapAdapterOne.notifyDataSetChanged();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_map_one;
    }

    @Override
    protected void beforeInitView() {
        dividerItemDecoration=new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL);
        dividerItemDecoration1=new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setColor(Color.parseColor("#a8a8a8"));
        dividerItemDecoration1.setColor(Color.parseColor("#a8a8a8"));
    }

    @Override
    protected void initView(View rootView) {
        rl_hotCity=findViewByIdNoCast(R.id.rl_hotCity);

    }

    @Override
    protected void initData() {
        mapAdapterOne=new MapAdapterOne(getContext());
        mapAdapterOne.setMapCallBack(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),4);
        rl_hotCity.addItemDecoration(dividerItemDecoration);
        rl_hotCity.addItemDecoration(dividerItemDecoration1);
        rl_hotCity.setLayoutManager(gridLayoutManager);
        rl_hotCity.setAdapter(mapAdapterOne);

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void OnItemClick(int position) {
        Toast.makeText(getActivity(),hotCityEntities.get(position).name,Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString("cityId",hotCityEntities.get(position).id);
        MyApplication.getMyApplication().setCityName(hotCityEntities.get(position).name);
        IntentUtils.openActivity(getActivity(), MainActivity.class,bundle);
        getActivity().finish();

    }
}
