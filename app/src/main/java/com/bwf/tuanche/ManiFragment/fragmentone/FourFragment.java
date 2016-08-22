package com.bwf.tuanche.ManiFragment.fragmentone;


import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.DividerItemDecoration;
import com.bwf.tuanche.ManiFragment.Adapter.GridViewAdapter4;
import com.bwf.tuanche.ManiFragment.ShouEntity.FourEntity;
import com.bwf.tuanche.R;

import java.util.List;

public class FourFragment extends BaseFragment{
    private RecyclerView rl_chexing;
    private DividerItemDecoration dividerItemDecoration;
    private DividerItemDecoration dividerItemDecoration1;
    private GridViewAdapter4 gridViewAdapter4;
    private List<FourEntity> fourEntity;

    public void setFourEntity(List<FourEntity> fourEntity) {

        this.fourEntity = fourEntity;
        gridViewAdapter4.setFourEntity(fourEntity);
        gridViewAdapter4.notifyDataSetChanged();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_four;
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
        rl_chexing=findViewByIdNoCast(R.id.rl_chexing);

    }

    @Override
    protected void initData() {
        gridViewAdapter4=new GridViewAdapter4(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        rl_chexing.addItemDecoration(dividerItemDecoration);
        rl_chexing.addItemDecoration(dividerItemDecoration1);
        rl_chexing.setLayoutManager(gridLayoutManager);
        rl_chexing.setAdapter(gridViewAdapter4);



    }

    @Override
    public void onClick(View view) {

    }
}
