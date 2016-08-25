package com.bwf.tuanche.xaingqing.View;

import android.content.Context;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.tuanche.R;

/**
 * Created by admin on 2016/7/26.
 */
public class TuancheDetailTitleBar extends RelativeLayout {
    private TextView   tv_title;
    private TextView   tv_titleimg_fenxiang;
    private TextView  tv_city111;
    public TuancheDetailTitleBar(Context context) {
        this(context,null);
    }
    public TuancheDetailTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TuancheDetailTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 初始化View
     */
    public  void initView(Context context) {
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        View view = View.inflate(context, R.layout.title_tuanche_detail, null);
        view.setLayoutParams(layoutParams);
        addView(view);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_city111 = (TextView) findViewById(R.id.tv_city111);
        tv_titleimg_fenxiang= (TextView) findViewById(R.id.tv_titleimg_fenxiang);
        tv_titleimg_fenxiang.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Pop pop=new Pop(getContext());
                pop.showPopWindow(tv_title);
            }
        });
    }
    /**
     * 设置标题
     */
    public void setTitle(String title, Spanned tv_city){
        tv_title.setText(title);
        tv_city111.setText(tv_city);
    }
}
