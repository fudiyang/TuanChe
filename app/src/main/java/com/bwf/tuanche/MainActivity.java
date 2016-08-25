package com.bwf.tuanche;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;

import com.bwf.framwork.tools.AppManager;

import com.bwf.framwork.utils.DrawableUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.ManiFragment.MianFragment;
import com.bwf.tuanche.ManiFragment.OrderFragment;
import com.bwf.tuanche.ManiFragment.PageFragment;
import com.bwf.tuanche.ManiFragment.ServiceFragment;
import com.bwf.tuanche.VersionUpdate.UpdateResultBean;


public class MainActivity extends BaseActivity implements Handler.Callback {
    private TextView tv_page, tv_order, tv_service, tv_main;
    private ImageView img_cheap;
    //未选中图片
    private Integer[] normal_ids = new Integer[]{R.mipmap.nav_icon_home_nor, R.mipmap.nav_icon_order_nor, R.mipmap.nav_icon_server_nor, R.mipmap.nav_icon_my_nor};
    //选中图片
    private Integer[] select_ids = new Integer[]{R.mipmap.nav_icon_home_sel, R.mipmap.nav_icon_order_sel, R.mipmap.nav_icon_server_sel, R.mipmap.nav_icon_my_sel};
    private TextView[] textViews;
    private PageFragment pageFragment;
    private OrderFragment orderFragment;
    private ServiceFragment serviceFragment;
    private MianFragment mianFragment;
    private FragmentManager fragmentManager;
    private String cityId, cityName;
    private Handler handler;
    private int oldVersionCode;
    private String oldVersionName;
    private String description, newVersionCode;
    private TextView dialog_text, text_version;
    private ImageView image_close;
    private Button button_update, text_intentsearch;
    private View view;
    private PopupWindow popupWindow;
    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void beforeInitView() {
        handler = new Handler(this);
//        cityId=cityId==null?"156":cityId;
        cityId = getIntent().getStringExtra("cityId");
        LogUtils.e("msg", "ssssss:" + cityId);
    }

    @Override
    public void initView() {
        PackageManager manager;
        PackageInfo info = null;
        manager = this.getPackageManager();
        try {
            info = manager.getPackageInfo(this.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        oldVersionCode = info.versionCode;
        oldVersionName = info.versionName;
        LogUtils.e("======================", oldVersionCode + "------" + oldVersionName);

        //fragment管理
        tv_page = findViewByIdNoCast(R.id.tv_page);
        tv_order = findViewByIdNoCast(R.id.tv_order);
        tv_service = findViewByIdNoCast(R.id.tv_service);
        tv_main = findViewByIdNoCast(R.id.tv_main);
        img_cheap = findViewByIdNoCast(R.id.img_cheap);
        //fragment 加载
        pageFragment = new PageFragment();
        pageFragment.setCityId(cityId);
        orderFragment = new OrderFragment();
        serviceFragment = new ServiceFragment();
        mianFragment = new MianFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.fre_content, pageFragment);
        ft.add(R.id.fre_content, orderFragment);
        ft.add(R.id.fre_content, serviceFragment);
        ft.add(R.id.fre_content, mianFragment);
        ft.hide(orderFragment);
        ft.hide(serviceFragment);
        ft.hide(mianFragment);
        ft.commit();

    }

    @Override
    public void initData() {
        textViews = new TextView[]{tv_page, tv_order, tv_service, tv_main};
        setOnClick(tv_page, tv_order, tv_service, tv_main);
        setOnClick(img_cheap);
        getdata();
    }

    public void getdata() {
        String url = UrlUtils.VERSION_UPDATA;
        HttpHelper.getUpdate(url, new HttpCallBack<UpdateResultBean>() {
            @Override
            public void onSuccess(UpdateResultBean result) {
                LogUtils.e("------------------", result.versionCode + "----" + result.versionName);
                //版本判断
                if (oldVersionCode < result.versionCode) {
                    if (result != null) {
                        description = result.description;
                        newVersionCode = String.valueOf(result.versionName);
                        initShow();
                        popupWindow.dismiss();
                        show();

                    }
                }
            }

            @Override
            public void onFail(String errMsg) {
                LogUtils.e("123123", errMsg);
            }
        });
    }

    //显示popwindow
    private void initShow() {
        view = View.inflate(this, R.layout.updata, null);
        dialog_text = (TextView) view.findViewById(R.id.dialog_text);
        button_update = (Button) view.findViewById(R.id.button_update);
        image_close = (ImageView) view.findViewById(R.id.image_close);
        text_version = (TextView) view.findViewById(R.id.text_version);
        dialog_text.setText(description);
        text_version.setText("V" + newVersionCode);
        LogUtils.e("dialog的文字", "description" + description);
        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        image_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image_close.setImageResource(R.mipmap.icon_close_click);
                popupWindow.dismiss();
            }
        });

    }

    //popwindow的位置
    private void show() {

        if (!popupWindow.isShowing())
        {
            view.postDelayed(new Runnable() {
                @Override
                public void run() {
                    popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
                }
            },100);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_page:
                setSelect(0);
                setTabSelection(0);

                break;
            case R.id.tv_order:
                setSelect(1);
                setTabSelection(1);
                break;
            case R.id.tv_service:
                setSelect(2);
                setTabSelection(2);
                break;
            case R.id.tv_main:
                setSelect(3);
                setTabSelection(3);
                break;
            case R.id.img_cheap:

                break;
        }

    }

    public void setSelect(int postion) {
        for (int i = 0; i < textViews.length; i++) {
            if (i == postion) {
                textViews[i].setTextColor(Color.RED);
                DrawableUtils.drawableTop(MainActivity.this, textViews[i], select_ids[i]);
            } else {
                textViews[i].setTextColor(Color.DKGRAY);
                DrawableUtils.drawableTop(MainActivity.this, textViews[i], normal_ids[i]);
            }
        }
    }

    private void setTabSelection(int index) {
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                if (pageFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    transaction.add(R.id.fre_content, pageFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(pageFragment);
                }
                break;
            case 1:
                if (orderFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    transaction.add(R.id.fre_content, orderFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(orderFragment);
                }
                break;
            case 2:
                if (serviceFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    transaction.add(R.id.fre_content, serviceFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(serviceFragment);
                }
                break;
            case 3:
                if (mianFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    transaction.add(R.id.fre_content, mianFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mianFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (pageFragment != null) {
            transaction.hide(pageFragment);
        }
        if (orderFragment != null) {
            transaction.hide(orderFragment);
        }
        if (serviceFragment != null) {
            transaction.hide(serviceFragment);

        }
        if (mianFragment != null) {
            transaction.hide(mianFragment);
        }
    }

    //定义一个间隔时间2秒
    private static final int TIMES = 2000;
    private boolean isBack = true;

    //按下监听  点2次返回键突出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {//按下返回键
            if (isBack) {
                ToastUtil.showToast("再点一次退出");
                isBack = false;
                handler.sendEmptyMessageDelayed(1, 2000);
            } else {
                //退出app
                AppManager.getInstance().AppExit(this);
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                isBack = true;
                break;
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (popupWindow != null) {
            popupWindow.dismiss();
        }

    }
}

