package com.bwf.tuanche;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.Adapter.HyAdapter;
import com.bwf.tuanche.View.Pop;
import com.bwf.tuanche.entiy.hunying.Rusert;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class HunyinActivity extends BaseActivity{
    private ListView hun_listview;
    private ImageView img_hunying;
    private HyAdapter adapter;




    @Override
    public int getContentViewId() {
        return R.layout.activity_hunyin;
    }

    @Override
    public void beforeInitView() {

    }
    @Override
    public void initView() {
        hun_listview = findViewByIdNoCast(R.id.hun_listview);
        img_hunying = findViewByIdNoCast(R.id.img_hunying);
    }
    @Override
    public void initData() {
        hun_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });


      getData();
    }
  public void getData(){
      String url= UrlUtils.TUANCHE_HUNYIN;
      HttpHelper.getHYDetail(url,new HttpCallBack<Rusert>() {
          @Override
          public void onSuccess(Rusert result) {
              if(result !=null){
                  adapter=new HyAdapter(HunyinActivity.this);
                  adapter.settList(result.carstyleList);
                  hun_listview.setAdapter(adapter);
                  ListViewUtils.measureListViewHeight(hun_listview);
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
