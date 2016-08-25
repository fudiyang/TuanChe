package com.bwf.tuanche.ManiFragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.tools.AppManager;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.ManiFragment.ShouEntity.FourEntity;
import com.bwf.tuanche.ManiFragment.ShouEntity.OneResultBean;
import com.bwf.tuanche.ManiFragment.ShouEntity.ThreeResultBean;
import com.bwf.tuanche.ManiFragment.ShouEntity.TwoRessultBean;
import com.bwf.tuanche.ManiFragment.fragmentone.FourFragment;
import com.bwf.tuanche.ManiFragment.fragmentone.OneFragment;
import com.bwf.tuanche.ManiFragment.fragmentone.ThreeFragment;
import com.bwf.tuanche.ManiFragment.fragmentone.TwoFragment;
import com.bwf.tuanche.MapActivity;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;
import com.bwf.tuanche.Search.Activity.SearchActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;


public class PageFragment extends BaseFragment {
    private OneFragment fre_one;
    private TwoFragment fre_two;
    private ThreeFragment fre_three;
    private FourFragment fre_four;
    private SimpleDraweeView img_pei;
    private TextView tv_title_city_name;
    private String cityId;
    private EditText ed_seach;

    public void setCityId(String cityId) {
        this.cityId = cityId;
//        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_page;
    }

    @Override
    protected void beforeInitView() {


    }

    @Override
    protected void initView(View rootView) {
        img_pei=findViewByIdNoCast(R.id.img_pei);
        tv_title_city_name=findViewByIdNoCast(R.id.tv_title_city_name);
        ed_seach=findViewByIdNoCast(R.id.ed_seach);
        tv_title_city_name.setText(MyApplication.getMyApplication().getCityName());

        fre_one= (OneFragment) getChildFragmentManager().findFragmentById(R.id.fre_one);
        fre_two= (TwoFragment) getChildFragmentManager().findFragmentById(R.id.fre_two);
        fre_three= (ThreeFragment) getChildFragmentManager().findFragmentById(R.id.fre_three);
        fre_four= (FourFragment) getChildFragmentManager().findFragmentById(R.id.fre_four);
        setOnClick(R.id.ed_seach);
        setOnClick(R.id.tv_title_city_name);
    }

    @Override
    protected void initData() {
        LogUtils.i("   cityId:     "+cityId);
        if(cityId != null) {
            getData();
            getPinpaiData();
            getBaoxianData();
            getChexingData();
        }

    }
    public void getData(){

        String Url= UrlUtils.One_URL;
        HttpHelper.getFregmentOne(Url, cityId, new HttpCallBack<OneResultBean>() {
            @Override
            public void onSuccess(OneResultBean result) {
                LogUtils.e("tag",""+result.nc);
                fre_one.setOneResultBean(result);
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }
    public void getPinpaiData(){
            String Url=UrlUtils.TWO_URL;
            HttpHelper.getFregmentTwo(Url, "2", cityId, new HttpCallBack<TwoRessultBean>(){

                @Override
                public void onSuccess(TwoRessultBean result) {
                    LogUtils.e("tag","TWO_URL:____________"+result.list);
                        fre_two.setList(result.list,cityId);
                }
                @Override
                public void onFail(String errMsg) {

                }
            });
    }
    public void getBaoxianData(){
        String Url=UrlUtils.THREE_URL;
        HttpHelper.getFregmentThree(Url,cityId, new HttpCallBack<ThreeResultBean>(){

            @Override
            public void onSuccess(ThreeResultBean result) {
                LogUtils.e("tag","THREE_URL:____________"+result);
                if (result!=null)
                    ImageLoader.getInstance().disPlayImage(img_pei,result.header_banner.get(0).adImgUrl);
                fre_three.setThreeResultBean(result,cityId);

            }
            @Override
            public void onFail(String errMsg) {

            }
        });
    }
    public void getChexingData(){
        String Url=UrlUtils.FOUR_URL;
        HttpHelper.getFregmentFour(Url,"20","10",cityId, new HttpArrayCallBack<FourEntity>() {
            @Override
            public void onSuccess(List<FourEntity> result) {
                if (result!=null){
                    LogUtils.e("tag","FourEntity_____________________________________:"+result);
                    fre_four.setFourEntity(result,cityId);

                }
            }
            @Override
            public void onFail(String errMsg) {

            }
        });


        }


    @Override
    public void onClick(View view) {
            switch (view.getId()){
                case R.id.tv_title_city_name:
                    Bundle bundle = new Bundle();
                    LogUtils.e("msg","cityName-->"+tv_title_city_name.getText().toString());
                    bundle.putString("cityName",tv_title_city_name.getText().toString());
//                    Intent intent = new Intent(getContext(),MapActivity.class);
//                    intent.putExtra("cityName",tv_title_city_name.getText().toString());
//                    startActivityForResult(intent,1);
                    IntentUtils.openActivity(getContext(),MapActivity.class,bundle);
                    break;
                case R.id.ed_seach:
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("cityId",cityId);
                    IntentUtils.openActivity(getContext(), SearchActivity.class,bundle1);
                    break;
            }
    }
}
