package com.bwf.framwork.http;


import com.bwf.tuanche.xaingqing.entiy.remen.BrandIDBean;
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
    public static void getPJDetail(String url,String offset,String cityId,String brandId,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("count","10")//
                .addParams("offset",offset)
                .addParams("cityId",cityId)
                .addParams("brandId",brandId)
                .build()
                .execute(callBack);
    }
    //低价购车
    public static void  getFregmentOne(String url,String cityId,HttpCallBack callBack) {
        OkHttpUtils.post().url(url)
                .addParams("cityId", cityId)
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
        OkHttpUtils.post()
                .url(url)
                .addParams("pageSize",pageSize)
                .build()
                .execute(callBack);
    }

    //根据车品牌获取车列表
    public static void getRenMen(String url,String type,String cityId,String brandId,HttpArrayCallBack<BrandIDBean> callBack){
        OkHttpUtils.post()
                .url(url)
                .addParams("type",type)
                .addParams("cityId",cityId)
                .addParams("brandId",brandId)
                .build()
                .execute(callBack);

    }
}
