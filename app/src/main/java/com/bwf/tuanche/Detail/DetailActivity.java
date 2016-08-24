package com.bwf.tuanche.Detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.Search.Activity.SearchActivity;
import com.bwf.tuanche.Search.entity.ed_search.EdSecondResult;
import com.bwf.tuanche.Search.entity.ed_search.EdThridBean;

import java.util.List;

/**
 * Created by admin on 2016/8/18.
 */
public class DetailActivity extends BaseActivity{
    private ImageView detail_back;
    private ListView listview_detail;
    private DetailAdapter detailAdapter;
    private TextView edit_detail_search;
    private EdThridBean request;
    private String brandId;
    @Override
    public int getContentViewId() {
        return R.layout.activity_detail;
    }

    @Override
    public void beforeInitView() {


        brandId= getIntent().getStringExtra("brandId");
//        LogUtils.e("request.brandId","request.brandId"+request.brandId);

    }

    @Override
    public void initView() {
        detail_back=findViewByIdNoCast(R.id.detail_back);
        listview_detail=findViewByIdNoCast(R.id.listview_detail);
        edit_detail_search=findViewByIdNoCast(R.id.edit_detail_search);

        setOnClick(detail_back);
    }

    @Override
    public void initData() {
        detailAdapter=new DetailAdapter(this);
        listview_detail.setAdapter(detailAdapter);
        getData();


        listview_detail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle=new Bundle();
//                bundle.putString("");
            }
        });
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.detail_back://点击返回键返回搜索
                IntentUtils.openActivity(this,SearchActivity.class);
            break;
            case R.id.edit_detail_search: // 点击搜索框返回搜索页面
                IntentUtils.openActivity(this,SearchActivity.class);
            break;
        }
    }

    public void getData(){
        String url = UrlUtils.SEARCH_CARSTYLE;
        HttpHelper.getSearch(url, 0, brandId, "156", new HttpArrayCallBack<EdSecondResult>() {
            @Override
            public void onSuccess(List<EdSecondResult> resultBean) {
                LogUtils.e("8888",resultBean.toString());
                edit_detail_search.setText(resultBean.get(0).brandName);
                detailAdapter.setTotalList(resultBean.get(0).styleList);
                detailAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFail(String errMsg) {

                LogUtils.e("detail",errMsg);
            }
        });
    }
}
