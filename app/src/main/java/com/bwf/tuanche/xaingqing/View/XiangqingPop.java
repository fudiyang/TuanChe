package com.bwf.tuanche.xaingqing.View;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.bwf.framwork.utils.DisplayUtil;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.xaingqing.Adapter.ListViewAdapter;
import com.bwf.tuanche.xaingqing.entiy.remen.BrandIDBean;
import com.bwf.tuanche.xaingqing.entiy.remen.BrandIDResultBean;

import java.util.List;

/**
 * Created by admin on 2016/8/23.
 */
public class XiangqingPop extends PopupWindow {
    private Context context;
    private List<BrandIDResultBean> result;
    private ListViewAdapter adapter;
    private ListView lv_pop;

    public void setBrandIDBeen(List<BrandIDResultBean> result) {
        this.result = result;
        adapter.settList(result);

    }
    public XiangqingPop(Context context) {
        super(context);
        this.context = context;
        init(context);
    }
    public void init(final Context context) {

        View view = View.inflate(context, R.layout.pop_xq, null);
        this.setContentView(view);
        this.setWidth((int) (DisplayUtil.getDensity_Width(context)*0.7));
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        this.setBackgroundDrawable(new BitmapDrawable());
        //设置popWindow动画
        this.setAnimationStyle(R.anim.popleft);
        adapter=new ListViewAdapter(context);
        lv_pop= (ListView) view.findViewById(R.id.lv_pop);
        lv_pop.setAdapter(adapter);
        adapter.notifyDataSetInvalidated();
    }
    /**
     * 显示pop
     */
    public void showPopWindow(View view) {
        if (!isShowing()) {
            this.showAsDropDown(view,((int)(DisplayUtil.getDensity_Width(context)*0.3)),0);
        }
    }
}
