package com.bwf.framwork.http;


import com.bwf.framwork.utils.UrlUtils;
import com.zhy.http.okhttp.OkHttpUtils;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description:
 */
public class HttpHelper {


    public static void getDetail(String url,String pageNo,String pageSize,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("pageNo", pageNo)
                .addParams("pageSize", pageSize)
                .build()
                .execute(callBack);
    }
    //低价购车
    public static void  getFregmentOne(String url,String cityId,HttpCallBack callBack){

        OkHttpUtils.post().url(url)
                .addParams("cityId",cityId)
                .build()
                .execute(callBack);

    }
    //热门品牌
    public static void  getFregmentTwo(String url,String isBuy,String cityId,HttpCallBack callBack){

        OkHttpUtils.post().url(url)
                .addParams("cityId",cityId)
                .addParams("isBuy",isBuy)
                .build()
                .execute(callBack);

    }
    //婚姻保驾
    public static void  getFregmentThree(String url,String cityId,HttpCallBack callBack){

        OkHttpUtils.post().url(url)
                .addParams("cityId",cityId)
                .build()
                .execute(callBack);

    }
    //热门车型
    public static void  getFregmentFour(String url,String count,String offset,String cityId,HttpArrayCallBack callBack){
        OkHttpUtils.post().url(url)
                .addParams("cityId",cityId)
                .addParams("count",count)
                .addParams("offset",offset)
                .build()
                .execute(callBack);

    }
    public static void  getMap(String url,String longitude,String latitude,HttpCallBack callBack){
        OkHttpUtils.post().url(url)
                .addParams("longitude",longitude)
                .addParams("latitude",latitude)
                .build()
                .execute(callBack);
    }
    public static void  getCity(String url,String pageSize,HttpCallBack callBack){
        OkHttpUtils.post().url(url)
                .addParams("pageSize",pageSize)
                .build()
                .execute(callBack);
    }
}
