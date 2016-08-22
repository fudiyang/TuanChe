package com.bwf.tuanche;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bwf.framwork.base.BaseActivity;

public class HyActivity extends BaseActivity {
  private Button btn_1,btn_2;

    @Override
    public int getContentViewId() {
        return R.layout.activity_hy;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        btn_1=findViewByIdNoCast(R.id.btn_1);
        btn_2=findViewByIdNoCast(R.id.btn_2);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.btn_1:
               Intent intent=new Intent(HyActivity.this,detailsActivity.class);
               startActivity(intent);
               break;
           case R.id.btn_2:
               Intent intent2=new Intent(HyActivity.this,HunyinActivity.class);
               startActivity(intent2);
               break;

       }
    }
}
