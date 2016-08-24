package com.bwf.tuanche.ManiFragment.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.ManiFragment.ShouEntity.TwoEntity;
import com.bwf.tuanche.R;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;

/**
 * Created by Cheng on 2016/8/17.
 * Description:
 */
public class GridViewAdapter2 extends RecyclerView.Adapter<GridViewAdapter2.MyViewHodler2> {

    private Context context;

    private  List<TwoEntity> list;
    private HotPinpaiCallBack hotPinpaiCallBack;

    public void setHotPinpaiCallBack(HotPinpaiCallBack hotPinpaiCallBack) {
        this.hotPinpaiCallBack = hotPinpaiCallBack;
    }

    public GridViewAdapter2(Context context) {
        this.context = context;
    }

    public void setList(List<TwoEntity> list) {
        this.list = list;
    }

    @Override
    public MyViewHodler2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.item_two,null);
        MyViewHodler2 viewHodler2 = new MyViewHodler2(view);
        viewHodler2.img_pinpai= (SimpleDraweeView) view.findViewById(R.id.img_pinpai);
        viewHodler2.tv_pinpai= (TextView) view.findViewById(R.id.tv_pinpai);
        viewHodler2.tv_baoming= (TextView) view.findViewById(R.id.tv_baoming);
        return viewHodler2;
    }

    @Override
    public void onBindViewHolder(MyViewHodler2 holder, final int position) {


            if(list.get(position).logo.equals("more")){
                holder.img_pinpai.setImageResource(R.mipmap.icon_more);
                holder.tv_baoming.setVisibility(View.GONE);
            }else
            ImageLoader.getInstance().disPlayImage(holder.img_pinpai, list.get(position).logo);
            holder.tv_pinpai.setText(list.get(position).name);
            String baoming = "已有<font color='red'>" + list.get(position).baseNum + "</font>人报名";
            holder.tv_baoming.setText(Html.fromHtml(baoming));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hotPinpaiCallBack!=null){
                    hotPinpaiCallBack.PinpaiOnItemClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class MyViewHodler2 extends RecyclerView.ViewHolder {
        private SimpleDraweeView img_pinpai;
        private TextView tv_pinpai,tv_baoming;

        public MyViewHodler2(View itemView) {
            super(itemView);
        }
    }
    public  interface  HotPinpaiCallBack{
        void PinpaiOnItemClick(int position);
    }
}
