package com.bwf.tuanche.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.bwf.tuanche.entiy.qichexiangqing.RootBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by admin on 2016/8/17.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHodler> {
    public List<RootBean> rootBean;
    private Context context;

    public RecyclerViewAdapter(Context context,List<RootBean> rootBean){
        this.context=context;
        this.rootBean=rootBean;
    }
    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item_view,null);
        ViewHodler viewHodler=new ViewHodler(view);
        viewHodler.tv_1= (TextView) view.findViewById(R.id.tv_1);
        viewHodler.tv_2= (TextView) view.findViewById(R.id.tv_2);
        viewHodler.img_tuanche_baozheng= (SimpleDraweeView) view.findViewById(R.id.img_tuanche_baozheng);

        return viewHodler;
    }

    @Override
    public void onBindViewHolder(ViewHodler holder, int position) {
        ImageLoader.getInstance().disPlayImage(holder.img_tuanche_baozheng,rootBean.get(position).imgurl);
        holder.tv_1.setText(rootBean.get(position).title);
        holder.tv_2.setText(rootBean.get(position).describe);
    }

    @Override
    public int getItemCount() {
        return  rootBean==null?0: rootBean.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private SimpleDraweeView img_tuanche_baozheng;
        private TextView tv_1;
        private TextView tv_2;


        public ViewHodler(View itemView) {
            super(itemView);
        }
    }

}
