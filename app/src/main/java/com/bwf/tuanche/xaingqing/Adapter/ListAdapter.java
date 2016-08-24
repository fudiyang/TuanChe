package com.bwf.tuanche.xaingqing.Adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.bwf.tuanche.xaingqing.entiy.qichexiangqing.CommentList;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by admin on 2016/8/17.
 */
public class ListAdapter extends BaseListAdpter <CommentList,ListAdapter.MyViewHodler>{
    public ListAdapter(Context context) {
        super(context);
    }
    @Override
    public int getResourceId() {
        return R.layout.item_adapter;
    }
    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent) {
       MyViewHodler myViewHodler=new MyViewHodler();
       myViewHodler.tv_11=findViewByIdNoCast(R.id.tv_11);
       myViewHodler.tv_12=findViewByIdNoCast(R.id.tv_12);
       myViewHodler.tv_13=findViewByIdNoCast(R.id.tv_13);
       myViewHodler.tv_14=findViewByIdNoCast(R.id.tv_14);
       myViewHodler.img_simpleDraweeView=findViewByIdNoCast(R.id.img_simpleDraweeView);
       return myViewHodler;
    }

    @Override
    public void onBindViewHolder(MyViewHodler holder, CommentList result, int position) {
        holder.tv_11.setText(result.userName);
        holder.tv_12.setRating(Float.parseFloat(result.score));
        holder.tv_13.setText(result.commentDate);
        holder.tv_14.setText(result.content);
        ImageLoader.getInstance().disPlayImage(holder.img_simpleDraweeView,result.memberPic);
    }
    public class MyViewHodler extends BaseListAdpter.ViewHolder{
        private TextView tv_11,tv_13,tv_14;
        private RatingBar tv_12;
        private SimpleDraweeView img_simpleDraweeView;
    }
}
