package com.bwf.tuanche.ManiFragment;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.R;


public class OrderFragment extends BaseFragment {
    private TextView tv_kuaisu,tv_zhanghao,tv_yanzhengma;
    private LinearLayout ll_kuaisu,ll_zhanghao;
    private EditText ed_kuaisuhao,ed_kuaisumi,ed_zhanghao,ed_zhanghaomi;
    private ImageView img_kuaisuzx,img_kuaisumx,img_zhanghaox,img_zhanghaomx;
    private Button btu_yanzheng,btu_denglu;

    @Override
    protected int getResource() {
        return R.layout.fragment_order;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        tv_kuaisu=findViewByIdNoCast(R.id.tv_kuaisu);
        tv_zhanghao=findViewByIdNoCast(R.id.tv_zhanghao);
        tv_yanzhengma=findViewByIdNoCast(R.id.tv_yanzhengma);
        ll_kuaisu=findViewByIdNoCast(R.id.ll_kuaisu);
        ll_zhanghao=findViewByIdNoCast(R.id.ll_zhanghao);
        ed_kuaisuhao=findViewByIdNoCast(R.id.ed_kuaisuhao);
        ed_kuaisumi=findViewByIdNoCast(R.id.ed_kuaisumi);
        ed_zhanghao=findViewByIdNoCast(R.id.ed_zhanghao);
        ed_zhanghaomi=findViewByIdNoCast(R.id.ed_zhanghaomi);
        img_kuaisuzx=findViewByIdNoCast(R.id.img_kuaisuzx);
        img_kuaisumx=findViewByIdNoCast(R.id.img_kuaisumx);
        img_zhanghaox=findViewByIdNoCast(R.id.img_zhanghaox);
        img_zhanghaomx=findViewByIdNoCast(R.id.img_zhanghaomx);
        btu_yanzheng=findViewByIdNoCast(R.id.btu_yanzheng);
        btu_denglu=findViewByIdNoCast(R.id.btu_denglu);
    }

    @Override
    protected void initData() {
        setOnClick(tv_kuaisu,tv_zhanghao,img_kuaisuzx,img_kuaisumx,ed_kuaisuhao,ed_kuaisumi,ed_zhanghao,ed_zhanghaomi,img_zhanghaox,img_zhanghaomx);
        ed_kuaisuhao.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (ed_kuaisuhao!=null){
                        img_kuaisuzx.setVisibility(View.VISIBLE);
                    }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        ed_kuaisumi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (ed_kuaisumi!=null){
                        img_kuaisumx.setVisibility(View.VISIBLE);
                    }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (ed_kuaisuhao!=null&&ed_kuaisumi!=null){
                    btu_yanzheng.setBackgroundResource(R.drawable.botton);
                }
            }
        });
        ed_zhanghao.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (ed_zhanghao!=null){
                        img_zhanghaox.setVisibility(View.VISIBLE);
                    }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        ed_zhanghaomi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (ed_zhanghaomi!=null){
                        img_zhanghaomx.setVisibility(View.VISIBLE);
                    }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_kuaisu :
                tv_kuaisu.setTextColor(Color.WHITE);
                tv_kuaisu.setBackgroundResource(R.mipmap.round_red_left);
                tv_zhanghao.setTextColor(Color.RED);
                tv_zhanghao.setBackgroundResource(R.mipmap.round_white_right);
                ll_zhanghao.setVisibility(View.GONE);
                ll_kuaisu.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_zhanghao :
                tv_zhanghao.setTextColor(Color.WHITE);
                tv_zhanghao.setBackgroundResource(R.mipmap.round_red_right);
                tv_kuaisu.setTextColor(Color.RED);
                tv_kuaisu.setBackgroundResource(R.mipmap.round_white_left);
                ll_zhanghao.setVisibility(View.VISIBLE);
                ll_kuaisu.setVisibility(View.GONE);
                break;
            case R.id.img_kuaisuzx :
                ed_kuaisuhao.setText(null);
                img_kuaisuzx.setVisibility(View.GONE);
                btu_yanzheng.setBackgroundResource(R.drawable.botton1);

                break;
            case R.id.img_kuaisumx :
                ed_kuaisumi.setText(null);
                img_kuaisumx.setVisibility(View.GONE);
                btu_yanzheng.setBackgroundResource(R.drawable.botton1);
                break;
            case R.id.img_zhanghaox :
                ed_zhanghao.setText(null);
                img_zhanghaox.setVisibility(View.GONE);
                btu_denglu.setBackgroundResource(R.drawable.botton1);
                break;
            case R.id.img_zhanghaomx :
                ed_zhanghaomi.setText(null);
                img_zhanghaomx.setVisibility(View.GONE);
                btu_denglu.setBackgroundResource(R.drawable.botton1);
                break;
        }
    }
}
