package com.bwf.framwork.http;


import com.zhy.http.okhttp.OkHttpUtils;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description:
 */
public class HttpHelper {
    //汽车详情
    public static void getDetail(String url,String styleId,String brandId,String cityId,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("styleId",styleId)
                .addParams("brandId",brandId)
                .addParams("cityId",cityId)
                .build()
                .execute(callBack);
    }

    public static void gettwoDetail(String url,String firmbrandId,String cityId,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("firmbrandId",firmbrandId)
                .addParams("cityId",cityId)
                .build()
                .execute(callBack);
    }
//更多评价
    public static void getPJDetail(String url,String count,String offset,String cityId,String brandId,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("count",count)
                .addParams("offset",offset)
                .addParams("cityId",cityId)
                .addParams("brandId",brandId)
                .build()
                .execute(callBack);
    }

    //婚姻座驾
    public static void getHYDetail(String url,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .build()
                .execute(callBack);
    }
    //城市
    public static void getcity(String url,String pageSize,HttpCallBack callBack){
       OkHttpUtils.post()
               .url(url)
               .addParams("pageSize",pageSize)
               .build()
               .execute(callBack);
    }
}
