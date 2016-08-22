package com.bwf.tuanche;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.ManiFragment.ShouEntity.CityResultBean;
import com.bwf.tuanche.ManiFragment.ShouEntity.MapEntity;
import com.bwf.tuanche.ManiFragment.fragmentone.MapOneFragment;
import com.bwf.tuanche.ManiFragment.fragmentone.MapTwoFragment;


public class MapActivity extends BaseActivity{
    public LocationClient mLocationClient=null;
    public BDLocationListener myListener=new MyLocationListener();
    private  String longitude;
    private  String latitude;
    private String  city;
    private TextView tv_dingwei,tv_city;
    private ImageView img_back;
    private MapOneFragment fre_mapone;
    private MapTwoFragment fre_maptwo;
    private String cityId;

    @Override
    public int getContentViewId() {
        return R.layout.activity_map;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        tv_dingwei= (TextView) findViewById(R.id.tv_dingwei);
        tv_city= (TextView) findViewById(R.id.tv_city);
        img_back= (ImageView) findViewById(R.id.img_back);
        fre_mapone= (MapOneFragment) getSupportFragmentManager().findFragmentById(R.id.fre_mapone);
        fre_maptwo= (MapTwoFragment) getSupportFragmentManager().findFragmentById(R.id.fre_maptwo);
    }

    @Override
    public void initData() {
        setOnClick(R.id.tv_dingwei,R.id.img_back);
        //声明LocationClient类
        mLocationClient=new LocationClient(getApplicationContext());
        //注册监听函数
        mLocationClient.registerLocationListener(myListener);
        initLocation();
        mLocationClient.start();
        getHotCityData();
    }
    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span=1000;//每个一秒定位一次
        option.setScanSpan(0);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);

    }
    //实现BDLocationListener接口
    //BDLocationListener接口有1个方法需要实现： 1.接收异步返回的定位结果，参数是BDLocation类型参数。
    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            if (location != null) {
                longitude = "" + location.getLongitude();//经度
                latitude = "" + location.getLatitude();//纬度
                city =   location.getCity();//城市
                String errCode = "" + location.getLocType();//网络定位 161代表成功
                Log.e("tag", "经度: " + longitude);
                Log.e("tag", "纬度: " + latitude);
                Log.e("tag", "errCode: " + errCode);
            }
            String Url= UrlUtils.MAP;
            HttpHelper.getMap(Url, longitude, latitude, new HttpCallBack<MapEntity>() {

                @Override
                public void onSuccess(MapEntity result) {
                    LogUtils.e("rdasdas:______________________"+result);
                    if(result==null) return;
                    tv_dingwei.setText(result.name);
                    cityId=result.id;
                }
                @Override
                public void onFail(String errMsg) {
                }
            });
        }
    }
    public void  getHotCityData(){

        String Url=UrlUtils.CITY;
        HttpHelper.getCity(Url, "4", new HttpCallBack<CityResultBean>() {

            @Override
            public void onSuccess(CityResultBean result) {
                LogUtils.e("dasasdf:____________________"+result);
                fre_mapone.setHotCityEntities(result.hotCitys);
                fre_maptwo.setCityEntities(result.openCitys);
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_dingwei:
                Bundle bundle = new Bundle();
                bundle.putString("cityId",cityId);
                MyApplication.getMyApplication().setCityName(city.toUpperCase().trim().substring(0,2));
                IntentUtils.openActivity(MapActivity.this,MainActivity.class,bundle);
                this.finish();
                break;
            case R.id.img_back:
                IntentUtils.openActivity(MapActivity.this,MainActivity.class);
                this.finish();
                break;
        }

    }
}
