package com.bwf.tuanche.ManiFragment.fragmentone;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.DividerItemDecoration;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.StringUtils;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.ManiFragment.Adapter.GridViewAdapter2;
import com.bwf.tuanche.ManiFragment.ShouEntity.TwoEntity;
import com.bwf.tuanche.ManiFragment.ShouEntity.TwoRessultBean;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;
import com.bwf.tuanche.detailsActivity;

import java.util.ArrayList;
import java.util.List;

public class TwoFragment extends BaseFragment implements GridViewAdapter2.HotPinpaiCallBack{
    private RecyclerView rl_pinpai;
    private GridViewAdapter2 adapter2;
    private List<TwoEntity> list;
    private DividerItemDecoration dividerItemDecoration;
    private DividerItemDecoration dividerItemDecoration1;
    private String cityId;

    public void setList(List<TwoEntity> list,String cityId) {
        this.list = list;
        this.cityId=cityId;
        list.add(new TwoEntity("更多","more"));
        adapter2.setList(list);
        adapter2.notifyDataSetChanged();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_two;
    }

    @Override
    protected void beforeInitView() {
        dividerItemDecoration=new DividerItemDecoration(getContext(),LinearLayoutManager.HORIZONTAL);
        dividerItemDecoration1=new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setColor(Color.parseColor("#a8a8a8"));
        dividerItemDecoration1.setColor(Color.parseColor("#a8a8a8"));
    }

    @Override
    protected void initView(View rootView) {
        rl_pinpai=findViewByIdNoCast(R.id.rl_pinpai);

    }

    @Override
    protected void initData() {
        adapter2=new GridViewAdapter2(getContext());
        GridLayoutManager  gridLayoutManager = new GridLayoutManager(getContext(),3);
        rl_pinpai.addItemDecoration(dividerItemDecoration);
        rl_pinpai.addItemDecoration(dividerItemDecoration1);
        rl_pinpai.setLayoutManager(gridLayoutManager);
        rl_pinpai.setAdapter(adapter2);



    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void PinpaiOnItemClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("cityId",cityId);
        bundle.putString("firmbrandId",list.get(position).id);

    }
}
