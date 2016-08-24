package com.bwf.framwork;

import com.bwf.framwork.db.model.UserModel;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description: 常量类
 */
public class Constants {

    public static final String DB_NAME = "tuanche_db";//数据库名称

    public static final int DB_VERSION = 1;//数据库版本

    //数据库所有的表
    public static String[] TABLES = new String[]{UserModel.class.getName()};

    public static final int  PANG_NUM=10;

}
