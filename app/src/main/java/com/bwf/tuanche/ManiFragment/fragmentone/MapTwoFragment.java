package com.bwf.tuanche.ManiFragment.fragmentone;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.DividerItemDecoration;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.ManiFragment.Adapter.MapAdapterOne;
import com.bwf.tuanche.ManiFragment.Adapter.MapAdapterTwo;
import com.bwf.tuanche.ManiFragment.ShouEntity.ListCityEntity;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;

import java.util.List;

public class MapTwoFragment extends BaseFragment implements MapAdapterTwo.MapCallBackList{
  private RecyclerView rl_ListCity;
  private MapAdapterTwo mapAdapterTwo;
  private List<ListCityEntity> cityEntities;
  private DividerItemDecoration dividerItemDecoration1;

  public void setCityEntities(List<ListCityEntity> cityEntities) {
    this.cityEntities = cityEntities;
    mapAdapterTwo.setListCityEntities(cityEntities);
    mapAdapterTwo.notifyDataSetChanged();
  }

  @Override
    protected int getResource() {
        return R.layout.fragment_map_two;
    }

    @Override
    protected void beforeInitView() {
      dividerItemDecoration1=new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL);
      dividerItemDecoration1.setColor(Color.parseColor("#a8a8a8"));

    }

    @Override
    protected void initView(View rootView) {
      rl_ListCity=findViewByIdNoCast(R.id.rl_ListCity);

    }

    @Override
    protected void initData() {
      mapAdapterTwo=new MapAdapterTwo(getContext());
      GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
      rl_ListCity.addItemDecoration(dividerItemDecoration1);
      rl_ListCity.setLayoutManager(gridLayoutManager);
      rl_ListCity.setAdapter(mapAdapterTwo);
      mapAdapterTwo.setMapCallBackList(this);

    }

    @Override
    public void onClick(View view) {

    }

  @Override
  public void OnItemListClick(int position) {
    Toast.makeText(getActivity(),cityEntities.get(position).name,Toast.LENGTH_SHORT).show();
    Bundle bundle = new Bundle();
    bundle.putString("cityId",cityEntities.get(position).id);
    MyApplication.getMyApplication().setCityName(cityEntities.get(position).name);
    IntentUtils.openActivity(getActivity(), MainActivity.class,bundle);
    getActivity().finish();

  }
}
