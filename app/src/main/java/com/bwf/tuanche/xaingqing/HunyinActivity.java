package com.bwf.tuanche.xaingqing;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.xaingqing.Adapter.HyAdapter;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.xaingqing.entiy.hunying.HyRusert;
import com.bwf.tuanche.xaingqing.entiy.hunying.Rusert;
import com.facebook.drawee.view.SimpleDraweeView;

public class HunyinActivity extends BaseActivity{
    private ListView hun_listview;
    private ImageView img_back1;
    private HyAdapter adapter;
    private SimpleDraweeView img_hunying;
    private HyRusert hyRusert;
    private String cityId;


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
        img_hunying=findViewByIdNoCast(R.id.img_hunying);
        img_back1.setOnClickListener(this);
    }
    @Override
    public void initData() {
        hun_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               hyRusert = (HyRusert) adapterView.getItemAtPosition(i);
                HyRusert hyRusert = (HyRusert) adapterView.getItemAtPosition(i);

                if(hyRusert !=null){
                    Bundle bundle=new Bundle();
                    bundle.putString("brandId",hyRusert.brandId);
                    bundle.putString("styleId",hyRusert.id);
                    bundle.putString("cityId",cityId);
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
                  ImageLoader.getInstance().disPlayImage(img_hunying,result.adpLogo);
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
