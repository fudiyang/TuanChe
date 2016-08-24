package com.bwf.tuanche.Search.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.framwork.bean.UserBean;
import com.bwf.tuanche.R;
import com.bwf.tuanche.Search.entity.ed_search.EdThridBean;

import java.util.List;

/**
 * Created by admin on 2016/8/17.
 */
public class SearchAdapter extends BaseAdapter{

    public Context context;
    public List<String> lists;
    public List<UserBean> userBeens;
    public List<EdThridBean> edThridBeen;

    public SearchAdapter(Context context) {
        this.context = context;
    }

    public void setResult(List<String> lists) {
        this.lists = lists;
    }

    public void setUserBeens(List<UserBean> userBeens) {
        this.userBeens = userBeens;
    }

    public void setEdThridBeen(List<EdThridBean> edThridBeen) {
        this.edThridBeen = edThridBeen;
    }

    @Override
    public int getCount() {
        return lists == null ? 0 : lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists == null ? null : lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_gridview, null);
            viewHolder.item_gridview_text = (TextView) convertView.findViewById(R.id.item_gridview_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (lists.get(position) != null)
            viewHolder.item_gridview_text.setText(lists.get(position));
        return convertView;
    }

    private class ViewHolder {
        TextView item_gridview_text;
    }
}
