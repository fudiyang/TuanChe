package com.bwf.tuanche.main.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.Search.Activity.SearchActivity;

/**
 * Created by admin on 2016/8/23.
 */
public class TitleBar extends LinearLayout implements View.OnClickListener{
    private Activity activity;
    private TextView text_chosecity,text_intentsearch;
    private ImageView image_erweima;

    public TitleBar(Context context) {
        this(context,null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context) {
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        View view = View.inflate(context, R.layout.main_titlebar, null);
        view.setLayoutParams(layoutParams);
        addView(view);
        text_chosecity = (TextView) findViewById(R.id.text_chosecity);
        text_intentsearch = (TextView) findViewById(R.id.text_intentsearch);
        image_erweima = (ImageView) findViewById(R.id.image_erweima);
        text_intentsearch.setOnClickListener(this);
        text_chosecity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text_intentsearch: //跳转搜索页面
                IntentUtils.openActivity(activity,SearchActivity.class);
            break;
            case R.id.text_chosecity:   //跳转城市选择页面
                IntentUtils.openActivity(activity,SearchActivity.class);
            break;
            case R.id.image_erweima:   //二维码扫描
            break;
        }
    }
}
