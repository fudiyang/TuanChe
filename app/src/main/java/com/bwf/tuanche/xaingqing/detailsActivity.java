package com.bwf.tuanche.xaingqing;


import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;

import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;
import com.bwf.tuanche.xaingqing.View.BottomView;
import com.bwf.tuanche.xaingqing.View.MyScrollview;
import com.bwf.tuanche.xaingqing.View.TuancheDetailTitleBar;
import com.bwf.tuanche.xaingqing.View.XiangqingPop;
import com.bwf.tuanche.xaingqing.entiy.qichexiangqing.Result;
import com.bwf.tuanche.xaingqing.entiy.qichexiangqing.RootBean;
import com.bwf.tuanche.xaingqing.entiy.remen.BrandIDBean;
import com.bwf.tuanche.xaingqing.entiy.remen.BrandIDResultBean;
import com.bwf.tuanche.xaingqing.fragment.Fragment_1;
import com.bwf.tuanche.xaingqing.fragment.Fragment_2;
import com.bwf.tuanche.xaingqing.fragment.Fragment_6;
import com.bwf.tuanche.xaingqing.fragment.Fragmetn_3;

import java.util.ArrayList;
import java.util.List;

public class detailsActivity extends BaseActivity implements MyScrollview.ScrollCallback,Fragment_2.Popcallbock,BottomView.Buttoncollback{
    private TuancheDetailTitleBar titleBar;
    private Fragment_1 tuache_fragment1;
    private Fragment_2 tuache_fragment2;
    private Fragmetn_3 tuache_fragment3;
    private Fragment_6 tuache_fragment6;
    private XiangqingPop xiangqingPop;
    private String cityId;
    private ImageView img_back;
    private BottomView bottomView;

    private MyScrollview myScrollview;
    //底部按钮的布局用来计算高度
    private LinearLayout linearLayout;
    //按钮的高度
    private int bottonHight;
    //按钮到顶部的高度
    private int Hight;

    private String brandId,styleId;

    private String name;
    @Override
    public int getContentViewId() {
        return R.layout.activity_details;

    }
    @Override
    public void beforeInitView() {
        name=MyApplication.getMyApplication().getCityName();
        brandId=getIntent().getStringExtra("brandId");
        styleId=getIntent().getStringExtra("styleId");
        cityId=getIntent().getStringExtra("cityId");
    }
    @Override
    public void initView(){
        xiangqingPop=new XiangqingPop(detailsActivity.this);
        titleBar=findViewByIdNoCast(R.id.titleBar);
        bottomView=findViewByIdNoCast(R.id.bottomView);
        img_back=findViewByIdNoCast(R.id.img_back);
        linearLayout=findViewByIdNoCast(R.id.ll_include);
        myScrollview=findViewByIdNoCast(R.id.scrollView);
        img_back.setOnClickListener(this);
        tuache_fragment1= (Fragment_1) getSupportFragmentManager().findFragmentById(R.id.tuache_fragment1);
        tuache_fragment2= (Fragment_2) getSupportFragmentManager().findFragmentById(R.id.tuache_fragment2);
        tuache_fragment3= (Fragmetn_3) getSupportFragmentManager().findFragmentById(R.id.tuache_fragment3);
        tuache_fragment6= (Fragment_6) getSupportFragmentManager().findFragmentById(R.id.tuache_fragment6);
    }

    @Override
    public void initData() {
        myScrollview.setScrollCallback(this);
        bottomView.setButtoncollback(this);

         getData();
         twoData();
        newgetData();
        getrenmenData();
    }

    public void getrenmenData() {
        String url = UrlUtils.TUANCHE_RENMEN;
      HttpHelper.getRenMen(url,"0",cityId,brandId, new HttpArrayCallBack<BrandIDBean>() {
          @Override
          public void onSuccess(List<BrandIDBean> result) {
              if(result != null&& !result.isEmpty()){
                  xiangqingPop.setBrandIDBeen(result.get(0).styleList);
              }
              Log.i("hy",result.toString());
          }

          @Override
          public void onFail(String errMsg) {

          }
      });
    }
    /**
     * 请求网络数据
     */
    public void getData(){
        String url = UrlUtils.TUANCHE_KEY;
        HttpHelper.getDetail(url,styleId,brandId,cityId,new HttpCallBack<Result>() {
            @Override
            public void onSuccess(Result result) {
                if(result !=null){
                    dismissSoftKeyboard(detailsActivity.this);
                    String str="<font color='red'>"+name+"站"+ "</font>";
                    titleBar.setTitle(result.styleName+"-",Html.fromHtml(str));
                    tuache_fragment1.setResultbean(result);
                    tuache_fragment2.setResult(result);
                    tuache_fragment2.setPopcallbock(detailsActivity.this);
                    tuache_fragment6.setResult(result.comment);
                    dismissSoftKeyboard(detailsActivity.this);
                }
            }
            @Override
            public void onFail(String errMsg) {
                dismissSoftKeyboard(detailsActivity.this);
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
            }
            @Override
            public void onFail(String errMsg) {
                dismissSoftKeyboard(detailsActivity.this);
            }
        });
    }
 public void twoData(){
     String url = UrlUtils.TUANCHE_KEY;
     HttpHelper.gettwoDetail(url,"",cityId,new HttpCallBack<Result>() {
         @Override
         public void onSuccess(Result result) {
             if (result != null) {
                 Log.i("hy","---->"+result.toString());
             }
         }
         @Override
         public void onFail(String errMsg) {
             dismissSoftKeyboard(detailsActivity.this);
         }
     });

 }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                detailsActivity.this.finish();
                break;
      }
    }
    /**
     * 计算出按钮的高度 还有按钮到父类顶部的高度
     * @param hasFocus
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            //按钮的高度
            bottonHight=linearLayout.getHeight();
            //按钮到父类顶部的高度
            Hight=linearLayout.getTop();
        }
    }

    @Override
    public void onScroll(int scrollY) {

    if(scrollY>=Hight+bottonHight){
        bottomView.setVisibility(View.VISIBLE);
    }else {
        bottomView.setVisibility(View.GONE);
    }
    }

    @Override
    public void popcallbock() {
        xiangqingPop.showPopWindow(titleBar);
    }

    @Override
    public void buttoncollback() {
        myScrollview.scrollTo(0,0);
        bottomView.setVisibility(View.GONE);
    }
}
