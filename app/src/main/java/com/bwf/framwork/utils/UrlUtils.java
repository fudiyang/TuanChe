package com.bwf.framwork.utils;

/**
 * Created by Lizhangfeng on 2016/7/19 0019.
 * Description:
 */
public class UrlUtils {


    public static final String BASE_URL = "http://123.56.145.151:8080/TuanCheNetWork/";
    /*  热门搜索*/
    public static final String HOT_SEARCH = BASE_URL + "bwf_TuanChe_SearchhotServlet";

    /*  搜索汽车品牌，车型*/
    public static final String SEARCH_CARSTYLE = BASE_URL + "bwf_TuanChe_BrandCarStyleServlet";

    /*  版本更新*/
    public static final String VERSION_UPDATA = BASE_URL + "bwf_TuanChe_VersionUpadteServlet";

   //汽车详情
    public static final String TUANCHE_KEY=BASE_URL+"bwf_TuanChe_BuyInfoServlet";
   //更多评价
    public static final String  TUANCHE_PJ=BASE_URL+"bwf_TuanChe_BuyInfoEvaluateServlet";
    //婚姻座驾
    public static final String TUANCHE_HUNYIN=BASE_URL+"bwf_TuanChe_AdplistServlet";

    //买贵赔3倍
    public static final String One_URL = BASE_URL +"bwf_TuanChe_HomeServlet";
    //热门品牌
    public static final String TWO_URL = BASE_URL +"bwf_TuanChe_TopBrand";
    //团车车险 婚姻座驾
    public static final String THREE_URL = BASE_URL +"bwf_TuanChe_BannerServlet";
    //热门车型
    public static final String FOUR_URL = BASE_URL +"bwf_TuanChe_Hotstyle";
    //地图
    public static final String MAP = BASE_URL +"bwf_TuanChe_QueryCityByLatitude";
    //城市列表
    public static final String CITY = BASE_URL +"bwf_TuanChe_Getcitys";


}

