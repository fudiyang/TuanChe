package com.bwf.tuanche;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.Search.Activity.SearchActivity;
import com.bwf.tuanche.VersionUpdate.UpdateResultBean;
import com.bwf.tuanche.main.view.BottomBar;
import com.bwf.tuanche.main.view.Fragment.Fragment_kefu;
import com.bwf.tuanche.main.view.Fragment.Fragment_main;
import com.bwf.tuanche.main.view.Fragment.Fragment_my;
import com.bwf.tuanche.main.view.TitleBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private int oldVersionCode;
    private String oldVersionName;
    private String description,newVersionCode;
    private TextView dialog_text,text_version,text_main,text_kefu,text_my,text_dingdan;
    private ImageView image_main,image_kefu,image_my,image_dingdan;
    private LinearLayout line_main,line_kefu,line_my,line_dingdan;
    private ImageView image_close;
    private Button button_update;
    private View view;
    private PopupWindow popupWindow;
    private TitleBar titleBar;
    private BottomBar bottomBar;
    private ViewPager viewPager;
    private LayoutInflater inflater;
    private List<View> views;
    private MyViewPager viewPagerAdapter;
    private int current=0;
    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }
    @Override
    public void beforeInitView() {
        titleBar = findViewByIdNoCast(R.id.titlebar);
        bottomBar =findViewByIdNoCast(R.id.bottombar);
        viewPagerAdapter =new MyViewPager(views,this);
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
        oldVersionCode= info.versionCode;
        oldVersionName=info.versionName;
        LogUtils.e("======================",oldVersionCode+"------"+oldVersionName);

        viewPager =findViewByIdNoCast(R.id.viewpager);
        text_main=findViewByIdNoCast(R.id.text_shouye);
        text_dingdan=findViewByIdNoCast(R.id.text_dingdan);
        text_kefu=findViewByIdNoCast(R.id.text_kefu);
        text_my=findViewByIdNoCast(R.id.text_my);
        image_main=findViewByIdNoCast(R.id.image_shouye);
        image_dingdan=findViewByIdNoCast(R.id.image_dingdan);
        image_kefu=findViewByIdNoCast(R.id.image_kefu);
        image_my=findViewByIdNoCast(R.id.image_my);
        line_main=findViewByIdNoCast(R.id.line_shouye);
        line_dingdan=findViewByIdNoCast(R.id.line_dingdan);
        line_kefu=findViewByIdNoCast(R.id.line_kefu);
        line_my=findViewByIdNoCast(R.id.line_my);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                showFragment(current);
                current = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    @Override
    public void initData() {
        getdata();
    }
    public void getdata(){
        String url= UrlUtils.VERSION_UPDATA;
        HttpHelper.getUpdate(url, new HttpCallBack<UpdateResultBean>() {
            @Override
            public void onSuccess(UpdateResultBean result) {
                LogUtils.e("------------------",result.versionCode+"----"+result.versionName);
                if(oldVersionCode<result.versionCode){
                    if(result != null){
                        description=result.description;
                        newVersionCode= String.valueOf(result.versionName);
                        initShow();
                        show();
                    }
                }
            }

            @Override
            public void onFail(String errMsg) {
                LogUtils.e("123123",errMsg);
            }
        });


    }
    private void initShow(){
        view=View.inflate(this,R.layout.updata,null);
        dialog_text= (TextView) view.findViewById(R.id.dialog_text);
        button_update= (Button) view.findViewById(R.id.button_update);
        image_close= (ImageView) view.findViewById(R.id.image_close);
        text_version= (TextView) view.findViewById(R.id.text_version);
        dialog_text.setText(description);
        text_version.setText("V"+newVersionCode);
        LogUtils.e("dialog的文字","description"+description);
        popupWindow =new PopupWindow(view,WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        image_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image_close.setImageResource(R.mipmap.icon_close_click);
                popupWindow.dismiss();
            }
        });

    }
    private void show(){
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.text_intentsearch:
                IntentUtils.openActivity(MainActivity.this,SearchActivity.class);
            break;
            case R.id.line_shouye:
                viewPager.setCurrentItem(0);
            break;
            case R.id.line_dingdan:
                viewPager.setCurrentItem(1);
            break;
            case R.id.line_kefu:
                viewPager.setCurrentItem(2);
            break;
            case R.id.line_my:
                viewPager.setCurrentItem(3);
            break;
        }
    }
    public void showFragment(int current){
        switch (current){
            case 0:
                image_main.setImageResource(R.mipmap.nav_icon_home_sel);
                text_main.setTextColor(Color.RED);
                image_dingdan.setImageResource(R.mipmap.nav_icon_order_nor);
                text_dingdan.setTextColor(Color.WHITE);
                image_kefu.setImageResource(R.mipmap.nav_icon_server_nor);
                text_kefu.setTextColor(Color.WHITE);
                image_my.setImageResource(R.mipmap.nav_icon_my_nor);
                text_my.setTextColor(Color.WHITE);
            break;
            case 1:
                image_main.setImageResource(R.mipmap.nav_icon_home_nor);
                text_main.setTextColor(Color.WHITE);
                image_dingdan.setImageResource(R.mipmap.nav_icon_order_sel);
                text_dingdan.setTextColor(Color.RED);
                image_kefu.setImageResource(R.mipmap.nav_icon_server_nor);
                text_kefu.setTextColor(Color.WHITE);
                image_my.setImageResource(R.mipmap.nav_icon_my_nor);
                text_my.setTextColor(Color.WHITE);
            break;
            case 2:
                image_main.setImageResource(R.mipmap.nav_icon_home_nor);
                text_main.setTextColor(Color.WHITE);
                image_dingdan.setImageResource(R.mipmap.nav_icon_order_nor);
                text_dingdan.setTextColor(Color.WHITE);
                image_kefu.setImageResource(R.mipmap.nav_icon_server_sel);
                text_kefu.setTextColor(Color.RED);
                image_my.setImageResource(R.mipmap.nav_icon_my_nor);
                text_my.setTextColor(Color.WHITE);
            break;
            case 3:
                image_main.setImageResource(R.mipmap.nav_icon_home_nor);
                text_main.setTextColor(Color.WHITE);
                image_dingdan.setImageResource(R.mipmap.nav_icon_order_nor);
                text_dingdan.setTextColor(Color.WHITE);
                image_kefu.setImageResource(R.mipmap.nav_icon_server_nor);
                text_kefu.setTextColor(Color.WHITE);
                image_my.setImageResource(R.mipmap.nav_icon_my_sel);
                text_my.setTextColor(Color.RED);
            break;
        }
    }
    public void initPagerChild() {
        inflater = LayoutInflater.from(this);
        views = new ArrayList<View>();
        View v1 = inflater.inflate(R.layout.fragment_main, null);
        View v2 = inflater.inflate(R.layout.fragment_kefu, null);
        View v3 = inflater.inflate(R.layout.fragment_my, null);
        views.add(v1);
        views.add(v2);
        views.add(v3);
    }

    public class MyViewPager extends PagerAdapter{

        private List<View> views;
        private Context context;


        public MyViewPager(List<View> views, Context context) {
            this.views = views;
            this.context = context;
        }

        @Override
        public int getCount() {
            return views ==null?null:views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view ==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView(views.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager) container).addView(views.get(position));
            return views.get(position);
        }
    }
}
