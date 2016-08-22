package com.bwf.tuanche.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.HunyinActivity;
import com.bwf.tuanche.ManiFragment.PageFragment;
import com.bwf.tuanche.R;

/**
 * Created by admin on 2016/7/26.
 */
public class HuanYingDetailTitleBar extends RelativeLayout {
    private TextView tv_titleimg_fenxiang;

    public HuanYingDetailTitleBar(Context context) {
        this(context,null);
    }
    public HuanYingDetailTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public HuanYingDetailTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 初始化View
     */
    public  void initView(final Context context) {
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        View view = View.inflate(context, R.layout.title_huanying, null);
        view.setLayoutParams(layoutParams);
        addView(view);
        tv_titleimg_fenxiang= (TextView) view.findViewById(R.id.tv_titleimg_fenxiang);
        tv_titleimg_fenxiang.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Pop pop=new Pop(getContext());
                pop.showPopWindow(tv_titleimg_fenxiang);
            }
        });

    }
}
