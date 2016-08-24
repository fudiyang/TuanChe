package com.bwf.framwork.http;


import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description:
 */
public class HttpHelper {


    public static void getDetail(String url,String pageNo,String pageSize,HttpCallBackSER callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("pageNo", pageNo)
                .addParams("pageSize", pageSize)
                .build()
                .execute(callBack);
    }

    /**
     * 热门搜索
     * @param url
     * @param cityId
     * @param callBack
     */
    public static void getHotSearch(String url, String cityId, StringCallback callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }

    //品牌详情
    public static void getSearch(String url,int type,String brandId, String cityId, StringCallback callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("type", ""+type)
                .addParams("brandId", ""+brandId)
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }
    //品牌详情
    public static void getUpdate(String url,StringCallback callBack){
        OkHttpUtils
                .post()
                .url(url)
                .build()
                .execute(callBack);
    }


}
