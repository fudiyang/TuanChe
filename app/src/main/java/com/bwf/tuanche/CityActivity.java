package com.bwf.tuanche;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.Adapter.CityAdapter;
import com.bwf.tuanche.entiy.frist.CityResultBean;
import com.bwf.tuanche.entiy.frist.ListCityEntity;

import java.util.ArrayList;
import java.util.List;

public class CityActivity extends BaseActivity {
   private ListView listView;
    private CityAdapter adapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_city;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        listView=findViewByIdNoCast(R.id.list);
    }
    @Override
    public void initData() {
       getData();
    }
     public void getData(){
         String url= UrlUtils.TUANCHE_CITY;
         HttpHelper.getcity(url, "4", new HttpCallBack<CityResultBean>() {
             @Override
             public void onSuccess(CityResultBean result) {
                 if(result !=null){
                     adapter=new CityAdapter(CityActivity.this);
                     adapter.settList(result.openCitys);
                     listView.setAdapter(adapter);
                     ListViewUtils.measureListViewHeight(listView);
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
