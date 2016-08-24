package com.bwf.tuanche.welcome.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwf.tuanche.welcome.fragment.GuidFragmentActivity;

/**
 * Created by XiaoBao on 2016/8/16.
 * Description
 */
public class GuidAdapter extends FragmentPagerAdapter {

    public GuidAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return GuidFragmentActivity.newInstance(position);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
