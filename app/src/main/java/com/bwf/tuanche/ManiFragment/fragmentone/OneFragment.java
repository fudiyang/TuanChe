package com.bwf.tuanche.ManiFragment.fragmentone;

import android.view.View;
import android.widget.GridView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.ManiFragment.Adapter.GridViewAdapter;
import com.bwf.tuanche.ManiFragment.ShouEntity.OneResultBean;
import com.bwf.tuanche.R;


public class OneFragment extends BaseFragment{
    private GridView gridView;
    private GridViewAdapter gridViewAdapter;
    private OneResultBean oneResultBean;

    public void setOneResultBean(OneResultBean oneResultBean) {
        this.oneResultBean = oneResultBean;
        if (oneResultBean != null)
        gridViewAdapter.settList(oneResultBean.nc);

    }



    @Override
    protected int getResource() {
        return R.layout.fragment_one;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        gridView =findViewByIdNoCast(R.id.gridView);

    }

    @Override
    protected void initData() {
        gridViewAdapter = new GridViewAdapter(getContext());
        gridView.setAdapter(gridViewAdapter);
        gridViewAdapter.notifyDataSetChanged();
    }



    @Override
    public void onClick(View view) {

    }
}
