package com.bwf.tuanche.xaingqing.fragment;

import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.tuanche.xaingqing.Adapter.ListAdapter;
import com.bwf.tuanche.xaingqing.PjActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.xaingqing.entiy.qichexiangqing.Comment;

public class Fragment_6 extends BaseFragment {
    private ListView listview;
    private TextView tv_pingjia;
    private TextView tv_or;
    private ListAdapter adapter;
    private RatingBar app_ratingbar;
    private Comment result;

    public void setResult(Comment result) {
        this.result = result;
        adapter=new ListAdapter(getContext());
        adapter.settList(result.commentList);
        listview.setAdapter(adapter);
        ListViewUtils.measureListViewHeight(listview);
        initData();
    }
    @Override
    protected int getResource() {
        return R.layout.fragment_fragment_6;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        listview = findViewByIdNoCast(R.id.listview);
        tv_pingjia = findViewByIdNoCast(R.id.tv_pingjia);
        app_ratingbar=findViewByIdNoCast(R.id.app_ratingbar);
        tv_or = findViewByIdNoCast(R.id.tv_or);
        tv_or.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        if(result !=null){
            app_ratingbar.setRating((float) result.commentTotal);
            String desc1 = "<font color='red'>"+"查看全部"+result.count+"人评论"+ "</font>";
            tv_or.setText(Html.fromHtml(desc1));

       }
    }

    @Override
    public void onClick(View view) {
          switch (view.getId()){
              case R.id.tv_or:
              Intent intent=new Intent(getContext(), PjActivity.class);
              startActivity(intent);
                  break;

          }
    }
}
