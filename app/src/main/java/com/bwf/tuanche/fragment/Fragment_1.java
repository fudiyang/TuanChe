package com.bwf.tuanche.fragment;


import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.bwf.tuanche.entiy.qichexiangqing.Result;
import com.facebook.drawee.view.SimpleDraweeView;


public class Fragment_1 extends BaseFragment{
    private SimpleDraweeView img_tuanche_qiche;
    private TextView fragment_jieyue;
    private TextView fragmeng1_renshu;
    private Result result;

    public void setResultbean(Result result) {
        this.result = result;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_fragment_1;
    }
    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        img_tuanche_qiche=findViewByIdNoCast(R.id.img_tuanche_qiche);
        fragmeng1_renshu=findViewByIdNoCast(R.id.fragmeng1_renshu);
        fragment_jieyue=findViewByIdNoCast(R.id.fragment_jieyue);
    }
    @Override
    protected void initData() {
      if(result !=null){
          ImageLoader.getInstance().disPlayImage(img_tuanche_qiche,result.logo);
          String desc = "<font color='#FF9F0E'>" + result.manNum +"人"+ "</font>";
          fragmeng1_renshu.setText(Html.fromHtml(desc));
          String desc1 = "<font color='#FF9F0E'>"+result.saveUpMoney+ "</font>";
          fragment_jieyue.setText(Html.fromHtml(desc1));

      }
    }

    @Override
    public void onClick(View view) {

    }
}
