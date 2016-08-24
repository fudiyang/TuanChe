package com.bwf.tuanche.View;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.framwork.utils.ShareUtil;
import com.bwf.tuanche.R;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

/**
 * Created by admin on 2016/8/18.
 */
public class Pop extends PopupWindow {
    private Context context;

    private TextView qq;
    private TextView qq_zone;
    private Button btn_quxiao;

    public Pop(Context context) {
        super(context);
        this.context = context;
        init(context);
    }
    public void init(final Context context) {
        View view = View.inflate(context,R.layout.pop_other_house, null);
        this.setContentView(view);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        this.setBackgroundDrawable(new BitmapDrawable());
//        // 实例化一个ColorDrawable颜色为半透明
//        ColorDrawable dw = new ColorDrawable(0xb0000000);
//        // 设置弹出窗体的背景
//        this.setBackgroundDrawable(dw);
        //设置popWindow动画
        this.setAnimationStyle(R.style.take_photo_anim);
        qq = (TextView) view.findViewById(R.id.qq);
        qq_zone = (TextView) view.findViewById(R.id.qq_zone);
        btn_quxiao = (Button) view.findViewById(R.id.btn_quxiao);
        btn_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pop.this.dismiss();
            }
        });

        //QQ空间分享
        qq_zone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareUtil.shareToQQ((Activity) context, SHARE_MEDIA.QZONE, "团车",
                        "大家来看看", "http://m.tuanche.com/cd/c166/tuan",
                        "http://pic.tuanche.com/car/20160714/14684806400978938_m.jpg", new UMShareListener() {
                            @Override
                            public void onResult(SHARE_MEDIA share_media) {
                                Toast.makeText(context, "分享成功了", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                                Toast.makeText(context, "分享失败了", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {
                                Toast.makeText(context, "取消", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });
        //QQ分享
        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareUtil.shareToQQ((Activity) context, SHARE_MEDIA.QQ, "团车",
                        "大家来看看", "http://m.tuanche.com/cd/c166/tuan",
                        "http://pic.tuanche.com/car/20160714/14684806400978938_m.jpg", new UMShareListener() {
                            @Override
                            public void onResult(SHARE_MEDIA share_media) {
                                Toast.makeText(context, "分享成功了", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                                Toast.makeText(context, "分享失败了", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {
                                Toast.makeText(context, "取消", Toast.LENGTH_SHORT).show();
                            }
                        });
            }

        });
    }

    /**
     * 显示pop
     */
    public void showPopWindow(View view) {
        if (!isShowing()) {
            this.showAsDropDown(view, 0, context.getResources().getDisplayMetrics().heightPixels / 2);
        }
    }


}


