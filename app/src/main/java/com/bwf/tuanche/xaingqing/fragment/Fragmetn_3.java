package com.bwf.tuanche.xaingqing.fragment;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.xaingqing.Adapter.RecyclerViewAdapter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.xaingqing.entiy.qichexiangqing.RootBean;

import java.util.List;

/**
 * 购车评价
 */
public class Fragmetn_3 extends BaseFragment {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<RootBean> rootBean;

    public void setRootBean(List<RootBean> rootBean) {
        this.rootBean = rootBean;
        adapter=new RecyclerViewAdapter(getContext(),rootBean);
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected int getResource() {
        return R.layout.fragment_fragmetn_3;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        recyclerView=findViewByIdNoCast(R.id.recyclerView);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }
}
