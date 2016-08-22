package com.bwf.tuanche;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.Adapter.HyAdapter;
import com.bwf.tuanche.View.HuanYingDetailTitleBar;
import com.bwf.tuanche.View.Pop;
import com.bwf.tuanche.entiy.hunying.HyRusert;
import com.bwf.tuanche.entiy.hunying.Rusert;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class HunyinActivity extends BaseActivity{
    private ListView hun_listview;
    private ImageView img_back1;
    private HyAdapter adapter;
<<<<<<< HEAD
    private HyRusert hyRusert;
    private String cityId;


=======
>>>>>>> houyao

    @Override
    public int getContentViewId() {
        return R.layout.activity_hunyin;
    }

    @Override
    public void beforeInitView() {
            hyRusert= new HyRusert();
        cityId=getIntent().getStringExtra("cityId");
    }
    @Override
    public void initView() {
        hun_listview = findViewByIdNoCast(R.id.hun_listview);
        img_back1=findViewByIdNoCast(R.id.img_back1);
        img_back1.setOnClickListener(this);
    }
    @Override
    public void initData() {
        hun_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
<<<<<<< HEAD
               hyRusert = (HyRusert) adapterView.getItemAtPosition(i);
=======
                HyRusert hyRusert = (HyRusert) adapterView.getItemAtPosition(i);
>>>>>>> houyao
                if(hyRusert !=null){
                    Bundle bundle=new Bundle();
                    bundle.putString("brandId",hyRusert.brandId);
                    bundle.putString("styleId",hyRusert.id);
<<<<<<< HEAD
                    bundle.putString("cityId",cityId);
=======
>>>>>>> houyao
                    IntentUtils.openActivity(HunyinActivity.this,detailsActivity.class,bundle);
                }
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
     switch (view.getId()){
         case R.id.img_back1:
              IntentUtils.openActivity(HunyinActivity.this,MainActivity.class);
             break;
     }
    }


}
