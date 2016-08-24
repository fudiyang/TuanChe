package com.bwf.tuanche.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.tuanche.R;

/**
 * Created by admin on 2016/8/23.
 */
public class BottomBar extends RelativeLayout {
    private TextView text_my,text_shouye,text_dingdan,text_kefu;
    private ImageView image_dijia;

    public BottomBar(Context context) {
        this(context,null);
    }

    public BottomBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BottomBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        View view = View.inflate(context, R.layout.main_bottombar, null);
        view.setLayoutParams(layoutParams);
        addView(view);
        text_shouye = (TextView) findViewById(R.id.text_shouye);
        text_dingdan = (TextView) findViewById(R.id.text_dingdan);
        text_kefu = (TextView) findViewById(R.id.text_kefu);
        text_my = (TextView) findViewById(R.id.text_my);
        image_dijia = (ImageView) findViewById(R.id.image_dijia);

    }
}
