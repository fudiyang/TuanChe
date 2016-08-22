package com.bwf.tuanche.welcome;

import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.share.SharePrefreceHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.MapActivity;
import com.bwf.tuanche.R;

public class WelcomeActivity extends BaseActivity implements Handler.Callback {

    private Handler handler;

    @Override

    public int getContentViewId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        handler = new Handler(this);
        handler.sendEmptyMessageDelayed(1, 3000);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (SharePrefreceHelper.getInstence(WelcomeActivity.this).isFirst()) {
                    IntentUtils.openActivity(this, GuidActivity.class);
                } else {
                    IntentUtils.openActivity(this, MapActivity.class);
                }
                finish();
                break;
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
