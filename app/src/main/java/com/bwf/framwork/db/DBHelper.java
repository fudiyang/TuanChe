package com.bwf.framwork.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bwf.framwork.Constants;
import com.bwf.framwork.base.BaseModel;
import com.bwf.tuanche.MyApplication;


/**
 * Created by Lizhangfeng on 2016/8/8 0008.
 * Description: 数据库帮助
 */
public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper dbHelper;

    public static DBHelper getInstence() {
        if (dbHelper == null)
            dbHelper = new DBHelper(MyApplication.getMyApplication().getApplicationContext());
        return dbHelper;
    }

    private DBHelper(Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表(第一次安装app的时候onCreate才执行)

        // getReadableDatabase();//主要用于查询
        // write;//增，删，改

        try {
            for (int i = 0; i < Constants.TABLES.length; i++) {
                Class<BaseModel> baseModelClass = (Class<BaseModel>) Class.forName(Constants.TABLES[i]);//根据类名反射拿到Class
                BaseModel baseModel = baseModelClass.newInstance();//根据Class拿到对象
                db.execSQL(baseModel.getCreateTableSql());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    /**
     * 数据库升级
     *
     * @param sqLiteDatabase
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        //oldVersion=1 newVersion=5
        //version=2 添加了一个 search表
        //version=3 添加了一个 detail表
        //version=4 添加了一个 history

        for (int i = oldVersion + 1; i < newVersion; i++) {
            switch (i) {
                case 2://
                    //search
                    break;
            }
        }


    }

    /**
     * 数据库降级
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }


}
