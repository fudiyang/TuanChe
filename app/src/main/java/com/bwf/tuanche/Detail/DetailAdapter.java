package com.bwf.tuanche.Detail;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.Search.entity.ed_search.EdSecondResult;
import com.bwf.tuanche.Search.entity.ed_search.EdThridBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by admin on 2016/8/18.
 */
public class DetailAdapter extends BaseAdapter {

    private Context context;
    private List<EdThridBean> totalList;
    private ImageLoader imageLoader;

    public DetailAdapter(Context context) {
        this.context = context;
        imageLoader = new ImageLoader();
    }

    public void setTotalList(List<EdThridBean> totalList) {
        this.totalList = totalList;
        LogUtils.e("sdfds",totalList.size()+"");
    }

    @Override
    public int getCount() {
        return totalList == null ? 0 : totalList.size();
    }

    @Override
    public Object getItem(int i) {
        return totalList == null ? null : totalList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View converview, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(converview ==null){
            viewHolder =new ViewHolder();
            converview =View.inflate(context, R.layout.item_detail,null);
            viewHolder.image_carstyle= (SimpleDraweeView) converview.findViewById(R.id.image_carstyle);
            viewHolder.text_carstyle= (TextView) converview.findViewById(R.id.text_carstyle);
            viewHolder.text_carprice= (TextView) converview.findViewById(R.id.text_carprice);
            viewHolder.text_man= (TextView) converview.findViewById(R.id.text_man);
            converview.setTag(viewHolder);
        }else {
             viewHolder= (ViewHolder) converview.getTag();
        }
        EdThridBean model =totalList.get(i);
        viewHolder.text_carstyle.setText("车型："+model.styleName);
        viewHolder.text_carprice.setText("指导价："+model.factoryPrice);
        String str="报名人数："+"已有<font color='red'>"+model.manNum+"</font>人报名";
        viewHolder.text_man.setText(Html.fromHtml(str));

        viewHolder.image_carstyle.setImageResource(R.mipmap.default_special_3);
//        imageLoader.disPlayImage((SimpleDraweeView) viewHolder.image_carstyle,model.styleList.get(i).logo);
        ImageLoader.getInstance().disPlayImage( viewHolder.image_carstyle,model.logo);
        return converview;
    }



    private class ViewHolder{
        SimpleDraweeView image_carstyle;//图片
        TextView text_carstyle;// 车型
        TextView text_carprice;//  指导价格
        TextView text_man;//  关注人数
    }
}
