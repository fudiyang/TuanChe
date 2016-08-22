package com.bwf.tuanche.ManiFragment;


import android.view.View;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.ManiFragment.ShouEntity.FourEntity;
import com.bwf.tuanche.ManiFragment.ShouEntity.OneResultBean;
import com.bwf.tuanche.ManiFragment.ShouEntity.ThreeResultBean;
import com.bwf.tuanche.ManiFragment.ShouEntity.TwoRessultBean;
import com.bwf.tuanche.ManiFragment.fragmentone.FourFragment;
import com.bwf.tuanche.ManiFragment.fragmentone.OneFragment;
import com.bwf.tuanche.ManiFragment.fragmentone.ThreeFragment;
import com.bwf.tuanche.ManiFragment.fragmentone.TwoFragment;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;
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

    public void setCityId(String cityId) {
        this.cityId = cityId;
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

        tv_title_city_name.setText(MyApplication.getMyApplication().getCityName());

        fre_one= (OneFragment) getChildFragmentManager().findFragmentById(R.id.fre_one);
        fre_two= (TwoFragment) getChildFragmentManager().findFragmentById(R.id.fre_two);
        fre_three= (ThreeFragment) getChildFragmentManager().findFragmentById(R.id.fre_three);
        fre_four= (FourFragment) getChildFragmentManager().findFragmentById(R.id.fre_four);
    }

    @Override
    protected void initData() {
                getData();
                getPinpaiData();
                getBaoxianData();
                getChexingData();
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
                        fre_two.setList(result.list);
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
                fre_three.setThreeResultBean(result);
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
                    fre_four.setFourEntity(result);

                }
            }
            @Override
            public void onFail(String errMsg) {

            }
        });


        }


    @Override
    public void onClick(View view) {

    }
}
