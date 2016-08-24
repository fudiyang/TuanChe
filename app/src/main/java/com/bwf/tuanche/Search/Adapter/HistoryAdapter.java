package com.bwf.tuanche.Search.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bwf.framwork.bean.UserBean;
import com.bwf.tuanche.R;
import java.util.List;

/**
 * Created by admin on 2016/8/18.
 */
public class HistoryAdapter extends BaseAdapter{
    public Context context;
    public List<UserBean> userBeens;

    public HistoryAdapter(Context context) {
        this.context = context;
    }


    public void setUserBeens(List<UserBean> userBeens) {
        this.userBeens = userBeens;
    }


    @Override
    public int getCount() {
        return userBeens == null ? 0 : userBeens.size();
    }

    @Override
    public Object getItem(int i) {
        return userBeens == null ? null : userBeens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

//        String string="yyyy.MM.dd.HH.mm";
//        SimpleDateFormat simpleDateFormat01=new SimpleDateFormat();
//        String time =simpleDateFormat01.format(string);

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_history, null);
            viewHolder.item_gridview = (TextView) convertView.findViewById(R.id.item_gridview);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (userBeens.get(position) != null)
            viewHolder.item_gridview.setText(userBeens.get(position).info);
        return convertView;
    }

    private class ViewHolder {
        TextView item_gridview;
    }
}
