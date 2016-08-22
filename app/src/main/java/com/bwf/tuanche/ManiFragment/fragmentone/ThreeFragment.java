package com.bwf.tuanche.ManiFragment.fragmentone;


import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.tuanche.ManiFragment.ShouEntity.ThreeResultBean;
import com.bwf.tuanche.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class ThreeFragment extends BaseFragment {
    private TextView tv_hunyin,tv_zuihao,tv_gouche,
                        tv_wenxin,tv_lvxing,tv_zou,tv_shangwu,tv_yilu,tv_bailing,tv_zizai,
                                 tv_daibu,tv_sheng;

    private SimpleDraweeView img_chetuan,img_baozhang,img_hunyin,img_gouche,img_lvxing,
                                img_shangwu,img_bailing,img_daibu;
    private ThreeResultBean threeResultBean;

    public void setThreeResultBean(ThreeResultBean threeResultBean) {
        this.threeResultBean = threeResultBean;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_three;
    }

    @Override
    protected void beforeInitView() {


    }

    @Override
    protected void initView(View rootView) {
        tv_hunyin=findViewByIdNoCast(R.id.tv_hunyin);
        tv_zuihao=findViewByIdNoCast(R.id.tv_zuihao);
        tv_gouche=findViewByIdNoCast(R.id.tv_gouche);
        tv_wenxin=findViewByIdNoCast(R.id.tv_wenxin);
        tv_lvxing=findViewByIdNoCast(R.id.tv_lvxing);
        tv_zou=findViewByIdNoCast(R.id.tv_zou);
        tv_shangwu=findViewByIdNoCast(R.id.tv_shangwu);
        tv_yilu=findViewByIdNoCast(R.id.tv_yilu);
        tv_bailing=findViewByIdNoCast(R.id.tv_bailing);
        tv_zizai=findViewByIdNoCast(R.id.tv_zizai);
        tv_daibu=findViewByIdNoCast(R.id.tv_daibu);
        tv_sheng=findViewByIdNoCast(R.id.tv_sheng);
        img_chetuan=findViewByIdNoCast(R.id.img_chetuan);
        img_baozhang=findViewByIdNoCast(R.id.img_baozhang);
        img_hunyin=findViewByIdNoCast(R.id.img_hunyin);
        img_gouche=findViewByIdNoCast(R.id.img_gouche);
        img_lvxing=findViewByIdNoCast(R.id.img_lvxing);
        img_shangwu=findViewByIdNoCast(R.id.img_shangwu);
        img_bailing=findViewByIdNoCast(R.id.img_bailing);
        img_daibu=findViewByIdNoCast(R.id.img_daibu);
    }

    @Override
    protected void initData() {
        if (threeResultBean!=null){
            ImageLoader.getInstance().disPlayImage(img_chetuan,threeResultBean.center_banner.get(0).adImgUrl);
            ImageLoader.getInstance().disPlayImage(img_baozhang,threeResultBean.center_banner.get(1).adImgUrl);
            ImageLoader.getInstance().disPlayImage(img_hunyin,threeResultBean.position_banner.get(0).iconUrl);
            ImageLoader.getInstance().disPlayImage(img_gouche,threeResultBean.position_banner.get(1).iconUrl);
            ImageLoader.getInstance().disPlayImage(img_lvxing,threeResultBean.position_banner.get(5).iconUrl);
            ImageLoader.getInstance().disPlayImage(img_shangwu,threeResultBean.position_banner.get(2).iconUrl);
            ImageLoader.getInstance().disPlayImage(img_bailing,threeResultBean.position_banner.get(3).iconUrl);
            ImageLoader.getInstance().disPlayImage(img_daibu,threeResultBean.position_banner.get(4).iconUrl);
            tv_hunyin.setText(threeResultBean.position_banner.get(0).bigTitle);
            tv_zuihao.setText(threeResultBean.position_banner.get(0).subTitle);
            tv_gouche.setText(threeResultBean.position_banner.get(1).bigTitle);
            tv_wenxin.setText(threeResultBean.position_banner.get(1).subTitle);
            tv_lvxing.setText(threeResultBean.position_banner.get(5).bigTitle);
            tv_zou.setText(threeResultBean.position_banner.get(5).subTitle);
            tv_shangwu.setText(threeResultBean.position_banner.get(2).bigTitle);
            tv_yilu.setText(threeResultBean.position_banner.get(2).subTitle);
            tv_bailing.setText(threeResultBean.position_banner.get(3).bigTitle);
            tv_zizai.setText(threeResultBean.position_banner.get(3).subTitle);
            tv_daibu.setText(threeResultBean.position_banner.get(4).bigTitle);
            tv_sheng.setText(threeResultBean.position_banner.get(4).subTitle);
        }

    }

    @Override
    public void onClick(View view) {

    }
}
