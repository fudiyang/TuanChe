package com.bwf.tuanche.xaingqing;


import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.xaingqing.Adapter.PjAdapter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.xaingqing.View.RefreshListView;
import com.bwf.tuanche.xaingqing.entiy.PJ.CommentList;
import com.bwf.tuanche.xaingqing.entiy.PJ.CommentPicList;

import java.util.ArrayList;
import java.util.List;

public class PjActivity extends BaseActivity {
    private TextView tv_pingfen, tv_011, tv_012, tv_013;
    private RefreshListView pj_listview;
    private PjAdapter adapter;
    private ImageView img_pj_back;
    private List<CommentList> listList;

    private RatingBar app_ratingbar_x;
    private int connt = 1;

    @Override
    public int getContentViewId() {
        return R.layout.activity_pj;
    }

    @Override
    public void beforeInitView() {
        listList=new ArrayList<>();

    }

    @Override
    public void initView() {
        tv_pingfen = findViewByIdNoCast(R.id.tv_pingfen);
        tv_011 = findViewByIdNoCast(R.id.tv_011);
        tv_012 = findViewByIdNoCast(R.id.tv_012);
        tv_013 = findViewByIdNoCast(R.id.tv_013);
        pj_listview = findViewByIdNoCast(R.id.pj_listview);
        img_pj_back = findViewByIdNoCast(R.id.img_pj_back);
        img_pj_back.setOnClickListener(this);
        app_ratingbar_x = findViewByIdNoCast(R.id.app_ratingbar_x);
    }

    @Override
    public void initData() {
        pj_listview.setOnLoadMoreListener(new RefreshListView.OnLoadMoreListener() {
            @Override
            public void loadMore() {
                connt++;
                getData();
            }
            @Override
            public void onRefresh() {
                connt=1;
                getData();
            }
        });
        getData();
    }
    public void getData() {
        String url = UrlUtils.TUANCHE_PJ;
        HttpHelper.getPJDetail(url, "" + connt,"156", "31", new HttpCallBack<CommentPicList>() {
            @Override
            public void onSuccess(CommentPicList result) {
                if (result != null) {
                    Log.i("jy", result.toString());
                    pj_listview.setOnComplete();
                    tv_pingfen.setText("总体评价：" + result.commentTotal);
                    tv_011.setText("价格" + result.priceScore);
                    tv_012.setText("团长服务" + result.salerScore);
                    tv_013.setText("4s店服务" + result.shopScore);
                    app_ratingbar_x.setRating((float) result.commentTotal);
                    if(connt==1){
                        adapter = new PjAdapter(PjActivity.this);
                        pj_listview.setAdapter(adapter);
                    }
                    listList.addAll(result.commentList);
                    adapter.settList(listList);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_pj_back:
                PjActivity.this.finish();
                break;
        }
    }
}
