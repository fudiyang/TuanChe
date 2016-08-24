package com.bwf.tuanche.ManiFragment.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.ManiFragment.ShouEntity.FourEntity;
import com.bwf.tuanche.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Cheng on 2016/8/18.
 * Description:
 */
public class GridViewAdapter4 extends RecyclerView.Adapter<GridViewAdapter4.MyViewHodler3>{

    private Context context;
    private List<FourEntity> fourEntity;
    private HotChexingCallBack hotChexingCallBack;

    public void setHotChexingCallBack(HotChexingCallBack hotChexingCallBack) {
        this.hotChexingCallBack = hotChexingCallBack;
    }

    public void setFourEntity(List<FourEntity> fourEntity) {
        this.fourEntity = fourEntity;
    }

    public GridViewAdapter4(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHodler3 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =View.inflate(context, R.layout.item_four,null);
        MyViewHodler3 myViewHodler3=new MyViewHodler3(view);
        myViewHodler3.img_cx_chexing= (SimpleDraweeView) view.findViewById(R.id.img_cx_chexing);
        myViewHodler3.tv_cx_pinpai= (TextView) view.findViewById(R.id.tv_cx_pinpai);
        myViewHodler3.tv_cx_baoming= (TextView) view.findViewById(R.id.tv_cx_baoming);
        myViewHodler3.tv_cx_zhidaojia= (TextView) view.findViewById(R.id.tv_cx_zhidaojia);
        return myViewHodler3;

    }

    @Override
    public void onBindViewHolder(MyViewHodler3 holder, final int position) {
        ImageLoader.getInstance().disPlayImage(holder.img_cx_chexing, fourEntity.get(position).logo);
        holder.tv_cx_pinpai.setText(fourEntity.get(position).styleName);
        String baoming = fourEntity.get(position).prefix+"<font color='red'>" + fourEntity.get(position).manNum + "</font>"+fourEntity.get(position).suffix;
        holder.tv_cx_baoming.setText(Html.fromHtml(baoming));
        holder.tv_cx_zhidaojia.setText(fourEntity.get(position).pricePrefix+fourEntity.get(position).price+fourEntity.get(position).priceSuffix);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hotChexingCallBack!=null){
                    hotChexingCallBack.StyleOnItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return fourEntity==null?0:fourEntity.size();
    }

    public  class MyViewHodler3 extends RecyclerView.ViewHolder{

        private SimpleDraweeView img_cx_chexing;
        private TextView tv_cx_pinpai,tv_cx_baoming,tv_cx_zhidaojia;

        public MyViewHodler3(View itemView) {
            super(itemView);
        }
    }


    public interface  HotChexingCallBack{
        void StyleOnItemClick(int position);
    }
}
