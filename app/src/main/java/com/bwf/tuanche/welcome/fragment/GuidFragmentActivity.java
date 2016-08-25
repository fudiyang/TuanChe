package com.bwf.tuanche.welcome.fragment;

import android.view.View;
import android.widget.ImageView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.share.SharePrefreceHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.MapActivity;
import com.bwf.tuanche.R;

public class GuidFragmentActivity extends BaseFragment {

    private int position;
    private ImageView first;




    public static GuidFragmentActivity newInstance(int position) {
        GuidFragmentActivity guidFragmentActivity = new GuidFragmentActivity();
        guidFragmentActivity.position = position;
        return guidFragmentActivity;
    }

    @Override
    protected int getResource() {
        return R.layout.activity_guid_fragment;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        first = findViewByIdNoCast(R.id.first);
    }

    @Override
    protected void initData() {

        setOnClick(R.id.first);
        switch (position) {
            case 1:
                first.setVisibility(View.VISIBLE);
                break;
        }
    }

    
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.first:
//                SharePrefreceHelper.getInstence(getActivity()).setIsFirst(false);
                first.setBackgroundResource(R.mipmap.start_btn_click);
                first.setImageResource(R.mipmap.start_btn_click);
                IntentUtils.openActivity(getContext(), MapActivity.class);
                getActivity().finish();
                break;
        }
    }
}
