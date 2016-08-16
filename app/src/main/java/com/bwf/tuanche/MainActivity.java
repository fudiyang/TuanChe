package com.bwf.tuanche;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.bwf.framwork.base.ReccleViewAdapter;
import com.bwf.framwork.bean.UserBean;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_test = (ListView) findViewById(R.id.lv_test);

        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("fdfd");
        list.add("14143");
        list.add("gsgd");
        list.add("sdsd");
        ReccleViewAdapter adapter = new ReccleViewAdapter(this);
        adapter.settList(list);
        lv_test.setAdapter(adapter);

        test();
    }

    public void test(){

        String url = "http://119.254.70.199:8080/landz-app/house/houseBuySellList";

        HttpHelper.getDetail(url,"0","10",new HttpCallBack<UserBean>() {

            @Override
            public void onFail(String errMsg) {

            }

            @Override
            public void onSuccess(UserBean result) {


            }

        });
    }

}
