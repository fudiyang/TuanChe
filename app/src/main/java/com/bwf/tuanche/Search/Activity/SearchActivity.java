package com.bwf.tuanche.Search.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bwf.framwork.CompareTo.CompareUserBean;
import com.bwf.framwork.Constants;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.bean.UserBean;
import com.bwf.framwork.db.model.UserModel;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpCallBackSER;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.Detail.DetailActivity;
import com.bwf.tuanche.Detail.DetailAdapter;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.Search.Adapter.HistoryAdapter;
import com.bwf.tuanche.Search.Adapter.SearchAdapter;
import com.bwf.tuanche.Search.entity.SearchResultBean;
import com.bwf.tuanche.Search.entity.ed_search.EdSecondResult;
import com.bwf.tuanche.Search.entity.ed_search.EdThridBean;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2016/8/16.
 */
public class SearchActivity extends BaseActivity {
    private ListView list_search,search_history;
    private ImageView search_back;
    private TextView text_search, text_search01,text_searchhistory;
    private EditText edit_search;
    private GridView gridView_search;
    private Button button_clean;
    private String cityId = "156";
    private String brandName;
    private SearchAdapter searchAdapter;
    private HistoryAdapter historyAdapter;
    private List<String> lists;
    private List<String> historyList;
    private List<EdThridBean> edThridBeen;
    private UserModel userModel;
    private UserBean userBean;
    private List<UserBean> userBeans;
    private CompareUserBean compareUserBean;

    @Override
    public int getContentViewId() {
        return R.layout.activity_search;
    }

    @Override
    public void beforeInitView() {
        searchAdapter = new SearchAdapter(this);
        historyAdapter=new HistoryAdapter(this);
        lists = new ArrayList<String>();
        userModel =new UserModel();
        userBean=new UserBean();
        compareUserBean=new CompareUserBean();

    }

    @Override
    public void initView() {
        search_back = findViewByIdNoCast(R.id.search_back); //返回上一界面
        text_search = findViewByIdNoCast(R.id.text_search); //搜索
        text_search01 = findViewByIdNoCast(R.id.text_search01);
        text_searchhistory = findViewByIdNoCast(R.id.text_searchhistory);
        edit_search = findViewByIdNoCast(R.id.edit_search); //ed输入框
        gridView_search = findViewByIdNoCast(R.id.search_gridview); //表格布局
        list_search = findViewByIdNoCast(R.id.list_search); //搜索的listview
        search_history =findViewByIdNoCast(R.id.search_history);
        button_clean=findViewByIdNoCast(R.id.button_clean);
        setOnClick(search_back, text_search, button_clean);

    }

    @Override
    public void initData() {
        list_search.setAdapter(searchAdapter);
        //  edit的输入监听
        edit_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String content = edit_search.getText().toString().trim();
                if (!TextUtils.isEmpty(content)) {

                    Log.e("msg","------------------------");
                    text_search01.setVisibility(View.GONE);
                    gridView_search.setVisibility(View.GONE);
                    list_search.setVisibility(View.VISIBLE);
                    getDataED();

                } else {

                    text_search01.setVisibility(View.VISIBLE);
                    gridView_search.setVisibility(View.VISIBLE);
                    list_search.setVisibility(View.GONE);
                    lists.clear();
                    searchAdapter.setResult(lists);
                    searchAdapter.notifyDataSetChanged();
                }
                getData();
            }

        });

        getData();

        list_search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String brandId = "";
//                EdThridBean bean01 = (EdThridBean) searchAdapter.getItem(i);
//                brandId = bean01.brandId;
//                LogUtils.e("brandId", "request.brandId" + brandId);
//                Bundle bundle = new Bundle();
//                bundle.putString("brandId", brandId);
//                IntentUtils.openActivity(SearchActivity.this, DetailActivity.class, bundle);
            }
        });




        gridView_search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String firmbrandId="";
                EdThridBean bean02 = (EdThridBean) searchAdapter.getItem(i);
                firmbrandId=bean02.firmBrandId;
                Bundle bundle =new Bundle();
                bundle.putString("firmbrandId",firmbrandId);
                IntentUtils.openActivity(SearchActivity.this,DetailActivity.class, bundle);

            }
        });

        // 一进入搜索页面 显示数据库中的历史记录
        userBeans=userModel.queryAllUsearBean();
        Collections.sort(userBeans, compareUserBean);
        historyAdapter.setUserBeens(userBeans);
        search_history.setAdapter(historyAdapter);
        search_history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                userBean.info =userBeans.get(i).info;
                Date date=new Date();
                String str ="yyyyMMddHHmmss";
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat(str);
                String timer =simpleDateFormat.format(date);
                LogUtils.e("date",timer);
                userBean.dateTime=timer;
                LogUtils.e("ed输入的内容：",userBean.toString());
                userModel.insertUser(userBean);
                userBeans=userModel.queryAllUsearBean();
                Collections.sort(userBeans, compareUserBean);
                historyAdapter.setUserBeens(userBeans);
                search_history.setAdapter(historyAdapter);
            }
        });
    }

    public void getData() {

        gridView_search.setAdapter(searchAdapter);
        String url = UrlUtils.HOT_SEARCH;
        HttpHelper.getHotSearch(url, "156", new HttpCallBackSER<SearchResultBean>() {
            @Override
            public void onSuccess(SearchResultBean resultBean) {
                LogUtils.e("1111", resultBean.result.toString());
                for (int i = 0; i < resultBean.result.length; i++) {
                    lists.add(resultBean.result[i].toString());// 数组遍历add进lists

                    LogUtils.e("2222", lists.toString());
                }
                searchAdapter.setResult(lists);
                searchAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFail(String errMsg) {

                LogUtils.e("3333", errMsg);
            }
        });
    }

    public void getDataED() {    //汽车搜索
        String url = UrlUtils.SEARCH_CARSTYLE;
        HttpHelper.getSearch(url, 0, "25", "156", new HttpArrayCallBack<EdSecondResult>() {
            @Override
            public void onSuccess(List<EdSecondResult> resultBean) {
                LogUtils.e("44444",resultBean.toString());

                searchAdapter.setEdThridBeen(resultBean.get(0).styleList);
                LogUtils.e("resultBean.get(0).styleList",resultBean.get(0).styleList.toString());
                searchAdapter.notifyDataSetChanged();

            }
            @Override
            public void onFail(String errMsg) {
                LogUtils.e("555",errMsg);
            }
        }) ;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_back:
              IntentUtils.openActivity(SearchActivity.this, MainActivity.class);    //返回主界面
                break;
            case R.id.text_search:   //  搜索按钮跳转并添加历史
                // 跳转至详情

                if(!edit_search.getText().toString().isEmpty()) {

                    String brandId="30";
                    Bundle bundle = new Bundle();
                    bundle.putString("brandId", brandId);
                    IntentUtils.openActivity(SearchActivity.this, DetailActivity.class, bundle);

                    //将ed框输入的内容添加进历史ListView
                    userBean.info=edit_search.getText().toString();
                    Date date=new Date();
                    String str ="yyyyMMddHHmmss";
                    SimpleDateFormat simpleDateFormat =new SimpleDateFormat(str);
                    String timer =simpleDateFormat.format(date);
                    LogUtils.e("date",timer);
                    userBean.dateTime=timer;
                    LogUtils.e("ed输入的内容：",userBean.toString());
                    userModel.insertUser(userBean);
                    userBeans=userModel.queryAllUsearBean();
                    Collections.sort(userBeans, compareUserBean);
                    historyAdapter.setUserBeens(userBeans);
                    search_history.setAdapter(historyAdapter);
                }
                break;
            case R.id.button_clean:
                userModel.clear();
                userBeans.clear();
                historyAdapter.setUserBeens(userBeans);
                historyAdapter.notifyDataSetChanged();
                break;
            case R.id.search_history:

                break;
        }

    }

}
