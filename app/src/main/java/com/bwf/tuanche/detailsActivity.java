package com.bwf.tuanche;

import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.View.TuancheDetailTitleBar;
import com.bwf.tuanche.entiy.qichexiangqing.Result;
import com.bwf.tuanche.entiy.qichexiangqing.RootBean;
import com.bwf.tuanche.fragment.Fragment_1;
import com.bwf.tuanche.fragment.Fragment_2;
import com.bwf.tuanche.fragment.Fragment_6;
import com.bwf.tuanche.fragment.Fragmetn_3;

import java.util.List;

public class detailsActivity extends BaseActivity {
    private TuancheDetailTitleBar titleBar;
    private Fragment_1 tuache_fragment1;
    private Fragment_2 tuache_fragment2;
    private Fragmetn_3 tuache_fragment3;
    private Fragment_6 tuache_fragment6;
    private String cityId;
    private String brandId,styleId;
    @Override
    public int getContentViewId() {
        return R.layout.activity_details;

    }
    @Override
    public void beforeInitView() {
        brandId=getIntent().getStringExtra("brandId");
        styleId=getIntent().getStringExtra("styleId");
        cityId=getIntent().getStringExtra("cityId");
    }

    @Override
    public void initView(){
        titleBar=findViewByIdNoCast(R.id.titleBar);
        tuache_fragment1= (Fragment_1) getSupportFragmentManager().findFragmentById(R.id.tuache_fragment1);
        tuache_fragment2= (Fragment_2) getSupportFragmentManager().findFragmentById(R.id.tuache_fragment2);
        tuache_fragment3= (Fragmetn_3) getSupportFragmentManager().findFragmentById(R.id.tuache_fragment3);
        tuache_fragment6= (Fragment_6) getSupportFragmentManager().findFragmentById(R.id.tuache_fragment6);
    }

    @Override
    public void initData() {
         getData();
        newgetData();
    }

    /**
     * 请求网络数据
     */
    public void getData(){
        String url = UrlUtils.TUANCHE_KEY;
        HttpHelper.getDetail(url,styleId,brandId,cityId,new HttpCallBack<Result>() {
            @Override
            public void onSuccess(Result result) {
                dismissSoftKeyboard(detailsActivity.this);
                titleBar.setTitle(result.styleName);
                tuache_fragment1.setResultbean(result);
                tuache_fragment2.setResult(result);
                tuache_fragment6.setResult(result.comment);
                dismissSoftKeyboard(detailsActivity.this);
            }
            @Override
            public void onFail(String errMsg) {
                dismissSoftKeyboard(detailsActivity.this);
                Log.i("hy","onFail---->"+errMsg);
            }
        });
    }
    public void newgetData(){
        String url = UrlUtils.TUANCHE_KEY;
        HttpHelper.getDetail(url,styleId,brandId,cityId,new HttpCallBack<Result>() {
            @Override
            public void onSuccess(Result result){
                dismissSoftKeyboard(detailsActivity.this);
               List<RootBean> list= JSON.parseArray(result.tcbzDesc,RootBean.class);
               tuache_fragment3.setRootBean(list);
                Log.i("hy",result.toString());
            }
            @Override
            public void onFail(String errMsg) {
                dismissSoftKeyboard(detailsActivity.this);
            }
        });
    }



    @Override
    public void onClick(View view) {

    }


}
