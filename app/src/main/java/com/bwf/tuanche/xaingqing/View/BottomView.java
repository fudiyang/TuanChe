package com.bwf.tuanche.xaingqing.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.bwf.tuanche.R;

public class BottomView extends LinearLayout {

    private Button btn_buttom_baoming;
    private Buttoncollback buttoncollback;


    public void setButtoncollback(Buttoncollback buttoncollback) {
        this.buttoncollback = buttoncollback;
    }

    public BottomView(Context context) {
        this(context,null);
    }

    public BottomView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BottomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context);
    }

    public void initData(Context context){
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        View view = View.inflate(context, R.layout.activity_bottom_view,null);
        view.setLayoutParams(layoutParams);
        addView(view);

        btn_buttom_baoming= (Button) findViewById(R.id.btn_buttom_baoming);

        btn_buttom_baoming.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttoncollback !=null){
                    buttoncollback.buttoncollback();
                }
            }
        });
    }

    public interface Buttoncollback{
        void buttoncollback();
    }

}
