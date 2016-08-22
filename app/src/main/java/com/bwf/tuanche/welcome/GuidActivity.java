package com.bwf.tuanche.welcome;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.welcome.adapter.GuidAdapter;
import com.bwf.tuanche.welcome.fragment.GuidFragmentActivity;

public class GuidActivity extends BaseActivity {

    private ViewPager viewPager;
    private ImageView guide;
    private GuidAdapter guidAdapter;
    private Integer[] images = new Integer[]{R.mipmap.guide01,R.mipmap.guide02};

    @Override
    public int getContentViewId() {
        return R.layout.activity_guid;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        viewPager = findViewByIdNoCast(R.id.viewpager);
        guide = findViewByIdNoCast(R.id.guide01);
    }

    @Override
    public void initData() {
        guidAdapter = new GuidAdapter(getSupportFragmentManager());
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setCheck(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(guidAdapter);
        setCheck(0);
    }

    @Override
    public void onClick(View view) {

    }
    public void setCheck(int position){
        guide.setImageResource(images[position]);
    }

}
